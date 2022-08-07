package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor{
	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected=false;
	private boolean mainFunctionExists=false;
	private Struct currentType=Tab.noType;
	
	//add bool type to universe scope
	public SemanticAnalyzer(){
		Tab.currentScope.addToLocals(new Obj(Obj.Type,"bool",new Struct(Struct.Bool)));
	}
	
	/* Logging */
	
	public void report_error(String str, SyntaxNode info) {
    	errorDetected = true;
    	StringBuilder msg = new StringBuilder("Error detected"); 
    	int errorLine = (info==null)?0:info.getLine();
    	if(errorLine!=0) {
    		msg.append(" at line ").append(errorLine);
    	}
    	msg.append(": ").append(str);
        log.error(msg.toString());
    }
	
	public void report_info(String str, SyntaxNode info) {
    	StringBuilder msg = new StringBuilder("Info"); 
    	int infoLine = (info==null)?0:info.getLine();
    	if(infoLine!=0) {
    		msg.append(" at line ").append(infoLine);
    	}
    	msg.append(": ").append(str);
        log.info(msg.toString());
    }
	
	/* Helper functions */
	private String structToString(Struct s) {
		switch(s.getKind()) {
			case Struct.None: return "none"; 
			case Struct.Int: return "int";
			case Struct.Char: return "char";
			case Struct.Bool: return "bool";
			case Struct.Array: return "array";
			default: return "other";
		}
	}
	
	/* Program */
	@Override
	public void visit(ProgramName programName) {
		programName.obj=Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {
		if(mainFunctionExists==false) {
			report_error("Function void main() doesn't exist.",null);
		}
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
	}
	
	/* Type */
	
	@Override
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode==Tab.noObj || typeNode.getKind()!=Obj.Type) {
			report_error(type.getTypeName()+" is not a valid type!",type);
			type.struct=Tab.noType;
		}
		else {
			type.struct=typeNode.getType();
		}
		currentType=type.struct;
	}
	
	/* Variables */
	
	//check if it's already declared
	private boolean varIsAlreadyDeclared(String varName, SyntaxNode info) {
		//only check current scope, if var is already declared in the outer scope then the outer var will be hidden
		if(Tab.currentScope.findSymbol(varName)==null) {	//TEST THIS
			return false;
		}
		report_error("Variable "+varName+" is already declared in the current scope!",info);
		return true;
	}
	
	//insert var into ST
	private Obj insertVarIntoTab(String varName, boolean varIsArray, SyntaxNode info) {
		if(currentType==Tab.noType) {
			report_error("Can't insert variable "+varName+" into symbol table because it doesn't have a type!", info);
			return Tab.noObj;
		}
		Struct varType=(varIsArray)?new Struct(Struct.Array,currentType):currentType;
		Obj varNode=Tab.insert(Obj.Var, varName, varType);
		if(varIsArray)
			report_info("Created new variable "+structToString(varType.getElemType())+" "+varName+"[].",info);
		else
			report_info("Created new variable "+structToString(varType)+" "+varName+".",info);
		return varNode;
	}
	
	@Override
	public void visit(VarSingle varSingle) {
		if(varIsAlreadyDeclared(varSingle.getVarName(),varSingle)) {
			return;
		}
		insertVarIntoTab(varSingle.getVarName(), false, varSingle);
	}
	
	@Override
	public void visit(VarArray varArray) {
		if(varIsAlreadyDeclared(varArray.getVarName(),varArray)) {
			return;
		}
		insertVarIntoTab(varArray.getVarName(), true, varArray);
	}
}