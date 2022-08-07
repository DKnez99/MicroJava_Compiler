package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor{
	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected=false;
	private boolean mainFunctionExists=false;
	private Struct currentType=TabEx.noType;
	
	//add bool type to universe scope
	public SemanticAnalyzer(){
		TabEx.currentScope.addToLocals(new Obj(Obj.Type,"bool",new Struct(Struct.Bool)));
	}
	
	/* ====================== Logging ======================*/
	
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
	
	/* ====================== Helper display functions ====================== */
	private String structToString(Struct s) {
		switch(s.getKind()) {
			case Struct.None: return "none"; 
			case Struct.Int: return "int";
			case Struct.Char: return "char";
			case Struct.Bool: return "bool";
			case Struct.Array: return "array";
			case Struct.Class: return "class";
			case Struct.Enum: return "enum";
			case Struct.Interface: return "interface";
			default: return "other";
		}
	}
	
	private String kindToString(int kind) {
		switch(kind) {
			case Obj.Con: return "constant";
			case Obj.Var: return "variable";
			case Obj.Prog: return "program";
			case Obj.Meth: return "method";
			case Obj.Type: return "type";
			case Obj.Elem: return "element";
			case Obj.Fld: return "field";
			case Obj.NO_VALUE: return "none";
			default: return "other";
		}
	}
	private String objectToString(Obj o) {
		StringBuilder sb=new StringBuilder("ObjNode[");
		sb.append("Name = "+o.getName());
		sb.append(", Type = "+structToString(o.getType()));
		sb.append(", Kind = "+kindToString(o.getKind()));
		if(kindToString(o.getKind())=="constant")
			sb.append(", Value = "+o.getAdr());
		else
			sb.append(", Address = "+o.getAdr());
		sb.append(", Level = "+o.getLevel()+"]");
		return sb.toString();
	}
	
	/* ====================== Program ====================== */
	@Override
	public void visit(ProgramName programName) {
		programName.obj=TabEx.insert(Obj.Prog, programName.getProgramName(), TabEx.noType);
		TabEx.openScope();
	}
	
	@Override
	public void visit(Program program) {
		if(mainFunctionExists==false) {
			report_error("Function void main() doesn't exist.",null);
		}
		TabEx.chainLocalSymbols(program.getProgramName().obj);
		TabEx.closeScope();
	}
	
	/* ====================== Type ====================== */
	@Override
	public void visit(Type type) {
		Obj typeNode = TabEx.find(type.getTypeName());
		if(typeNode==TabEx.noObj || typeNode.getKind()!=Obj.Type) {
			report_error(type.getTypeName()+" is not a valid type!",type);
			type.struct=TabEx.noType;
		}
		else {
			type.struct=typeNode.getType();
		}
		currentType=type.struct;
	}
	
	/* ====================== Variables ====================== */
	//check if it's already declared
	private boolean varIsDeclared(String varName, SyntaxNode info) {
		//only check current scope, if var is already declared in the outer scope then the outer var will be hidden
		if(TabEx.currentScope.findSymbol(varName)==null) {
			return false;
		}
		return true;
	}
	
	//insert var into ST
	private Obj insertVarIntoTab(String varName, boolean varIsArray, SyntaxNode info) {
		if(currentType==TabEx.noType) {
			report_error("Can't insert variable "+varName+" into symbol table because it doesn't have a type!", info);
			return TabEx.noObj;
		}
		Struct varType=(varIsArray)?new Struct(Struct.Array,currentType):currentType;
		Obj varNode=TabEx.insert(Obj.Var, varName, varType);
		StringBuilder msg = new StringBuilder("Created new variable ");
		if(varIsArray==true)
			msg.append(structToString(varType.getElemType())+" "+varName+"[]. ");
		else
			msg.append(structToString(varType)+" "+varName+". ");
		msg.append(objectToString(varNode));
		report_info(msg.toString(),info);
		return varNode;
	}
	
	@Override
	public void visit(VarSingle varSingle) {
		if(varIsDeclared(varSingle.getVarName(),varSingle)==true) {
			report_error("Variable "+varSingle.getVarName()+" has already been declared in the current scope!", varSingle);
			return;
		}
		insertVarIntoTab(varSingle.getVarName(), false, varSingle);
	}
	
	@Override
	public void visit(VarArray varArray) {
		if(varIsDeclared(varArray.getVarName(),varArray)==true) {
			report_error("Variable "+varArray.getVarName()+"[] has already been declared in the current scope!", varArray);
			return;
		}
		insertVarIntoTab(varArray.getVarName(), true, varArray);
	}
	
	@Override
	public void visit(VarDecl varDecl) {
		//end of var decl list
		currentType=TabEx.noType;
	}
	
	/* ====================== Constants ====================== */
	//check if it's already declared
	private boolean constIsDeclared(String constName, SyntaxNode info) {
		//only check current scope, if const is already declared in the outer scope then the outer const will be hidden
		if(TabEx.currentScope.findSymbol(constName)==null) {
			return false;
		}
		return true;
	}
	
	//check if dst and src types match
	private boolean constTypeMatches(String constName, Struct assignedType, SyntaxNode info) {
		if(assignedType.equals(currentType)) {
			return true;
		}
		report_error("Type mismatch when assigning "+structToString(assignedType)+" value to constant "+structToString(currentType)+" "+constName+".", info);
		return false;
	}
	
	//insert const into ST
	private Obj insertConstIntoTab(String constName, int constValue, SyntaxNode info) {
		if(currentType==TabEx.noType) {
			report_error("Can't insert constant "+constName+" into symbol table because it doesn't have a type!", info);
			return TabEx.noObj;
		}
		Struct constType=currentType;
		Obj constNode=TabEx.insert(Obj.Con, constName, constType);
		constNode.setAdr(constValue);
		report_info("Created new constant "+structToString(constType)+" "+constName+". "+objectToString(constNode),info);
		return constNode;
	}
	
	@Override
	public void visit(ConstAssignNum constAssignNum) {
		if(constIsDeclared(constAssignNum.getConstName(),constAssignNum)==true) {
			return;
		}
		
		if(constTypeMatches(constAssignNum.getConstName(),TabEx.intType,constAssignNum)==false) {
			return;
		}
		
		insertConstIntoTab(constAssignNum.getConstName(),constAssignNum.getNumberValue(),constAssignNum);
	}
	
	@Override
	public void visit(ConstAssignChar constAssignChar) {
		if(constIsDeclared(constAssignChar.getConstName(),constAssignChar)==true) {
			return;
		}
		
		if(constTypeMatches(constAssignChar.getConstName(),TabEx.charType,constAssignChar)==false) {
			return;
		}
		
		insertConstIntoTab(constAssignChar.getConstName(),constAssignChar.getCharValue(),constAssignChar);
	}
	
	@Override
	public void visit(ConstAssignBool constAssignBool) {
		if(constIsDeclared(constAssignBool.getConstName(),constAssignBool)==true) {
			return;
		}
		
		if(constTypeMatches(constAssignBool.getConstName(),TabEx.boolType,constAssignBool)==false) {
			return;
		}
		int boolValue=(constAssignBool.getBoolValue()==true)?1:0;
		insertConstIntoTab(constAssignBool.getConstName(),boolValue,constAssignBool);
	}
	
	@Override
	public void visit(ConstDecl constDecl) {
		//end of var decl list
		currentType=TabEx.noType;
	}
}