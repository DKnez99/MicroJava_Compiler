package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor{
	Logger log = Logger.getLogger(getClass());
	public boolean errorDetected=false;
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
			report_error("Can't insert variable "+varName+" into symbol table because it doesn't have a valid type!", info);
			return TabEx.noObj;
		}
		Struct varType=(varIsArray)?new Struct(Struct.Array,currentType):currentType;
		Obj varNode=TabEx.insert(Obj.Var, varName, varType);
		StringBuilder msg = new StringBuilder("Created new variable ");
		if(varIsArray==true) {
			msg.append(structToString(varType.getElemType())+" "+varName+"[]. ");
		}
		else {
			msg.append(structToString(varType)+" "+varName+". ");
		}
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
	/* ====================== Designators ====================== */
	@Override
	public void visit(DesignatorDefault designatorDefault) {
		String designatorName=designatorDefault.getDesignatorName();
		designatorDefault.obj=TabEx.find(designatorName);
		if(designatorDefault.obj==TabEx.noObj) {
			report_error(designatorName+" hasn't been declared yet!",designatorDefault);
		}
		else {
			Struct designatorType=designatorDefault.obj.getType();
			String designatorTypeName=structToString(designatorType);
			int designatorKind=designatorDefault.obj.getKind();
			String designatorKindName=kindToString(designatorKind);
			
			if(designatorType.getKind()!=Struct.Array) {
				report_info("Accessed a "+designatorKindName+" "+designatorTypeName+" "+designatorName+".",designatorDefault);
			}
			else {
				String elemTypeName=structToString(designatorDefault.obj.getType().getElemType());
				report_info("Accessed a "+designatorKindName+" "+elemTypeName+" "+designatorName+"[].",designatorDefault);
			}
		}
	}
	
	private boolean arrayIsArrayType(Struct arrayType) {
		if(arrayType.getKind()!=Struct.Array) {
			return false;
		}
		return true;
	}
	
	private boolean arrayIndexIsInt(Struct indexType) {
		if(indexType!=TabEx.intType) {
			return false;
		}
		return true;
	}
	
	@Override
	public void visit(DesignatorArray designatorArray) {
		String arrayName=designatorArray.getDesignator().obj.getName();
		Struct arrayType=designatorArray.getDesignator().obj.getType();
		String arrayTypeName=structToString(arrayType);
		Struct indexType=designatorArray.getExpr().struct;
		if(arrayIsArrayType(arrayType)==false) {
			report_error("Not possible to access element of "+arrayTypeName+" "+arrayName+" as it's not an array!",designatorArray);
			designatorArray.obj=TabEx.noObj;
			return;
		}
		Struct elemType=arrayType.getElemType();
		String elemTypeName=structToString(elemType);
		
		//uncomment when you implement expr types
		if(arrayIndexIsInt(indexType)==false) {
			report_error("Index of "+elemTypeName+" "+arrayName+"[] must be of type int!",designatorArray);
			designatorArray.obj=TabEx.noObj;
			return;
		}
		
		report_info("Accessed an element of "+elemTypeName+" "+arrayName+"[].",designatorArray);
		designatorArray.obj=new Obj(Obj.Elem, arrayName, elemType);	//CHECK
	}
	
	/* ====================== Factors ====================== */
	@Override
	public void visit(FactorDesignator factorDesignator) {
		if(factorDesignator.getDesignator().obj.equals(TabEx.noObj)) {
			factorDesignator.struct=TabEx.noType;
			return;
		}	
		factorDesignator.struct=factorDesignator.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(FactorConstNum factorConstNum) {
		factorConstNum.struct=TabEx.intType;
	}
	
	@Override
	public void visit(FactorConstChar factorConstChar) {
		factorConstChar.struct=TabEx.charType;
	}
	
	@Override
	public void visit(FactorConstBool factorConstBool) {
		factorConstBool.struct=TabEx.boolType;
	}
	
	@Override
	public void visit(FactorNewArray factorNewArray) {
		Struct exprType=factorNewArray.getExpr().struct;
		String exprTypeName=structToString(exprType);
		Struct elemType=factorNewArray.getType().struct; //int<-- arr[] for example
		if(exprType!=Tab.intType) {
			factorNewArray.struct=TabEx.noType;
			report_error("Expression representing the number of elements of an array can't be of type "+exprTypeName+"!",factorNewArray);
			return;
		}
		factorNewArray.struct=new Struct(Struct.Array,elemType);
	}
	
	@Override
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct=factorExpr.getExpr().struct;
	}
	
	/* ====================== Terms ====================== */
	
	@Override
	public void visit(Term term) {
		Struct factorType=term.getFactor().struct;
		Struct factorListType=term.getMulopFactorListNullable().struct;
		String factorTypeName=structToString(factorType);
		if(factorType!=TabEx.intType && factorListType!=TabEx.noType) {
			term.struct=TabEx.noType;
			report_error("Can't perform math operations on factors of type "+factorTypeName+".",term);
			return;
		}
		term.struct=factorType;
	}
	
	@Override
	public void visit(MulopFactorList mulopFactorList) {
		Struct factorType=mulopFactorList.getFactor().struct;
		String factorTypeName=structToString(factorType);
		if(factorType!=TabEx.intType) {
			mulopFactorList.struct=TabEx.noType;
			report_error("Can't perform math operations on factors of type "+factorTypeName+".",mulopFactorList);
			return;
		}
		mulopFactorList.struct=TabEx.intType;
	}
	
	@Override
	public void visit(EmptyMulopFactorList emptyMulopFactorList) {
		emptyMulopFactorList.struct=TabEx.noType;
	}
	/* ====================== Expressions ====================== */
	@Override
	public void visit(ExprTerm exprTerm) {
		Struct termType=exprTerm.getTerm().struct;
		String termTypeName=structToString(termType);
		Struct termListType=exprTerm.getAddopTermListNullable().struct;
		if(termType!=TabEx.intType && termListType!=TabEx.noType) {
			exprTerm.struct=TabEx.noType;
			report_error("Can't perform math operations on first term (type: "+termTypeName+") in the chain.",exprTerm);
			return;
		}
		exprTerm.struct=exprTerm.getTerm().struct;
	}
	
	@Override
	public void visit(ExprNegTerm exprNegTerm) {
		Struct termType=exprNegTerm.getTerm().struct;
		String termTypeName=structToString(termType);
		if(termType!=TabEx.intType) {
			report_error("Can't negate "+termTypeName+" type!",exprNegTerm);
			exprNegTerm.struct=TabEx.noType;
			return;
		}
		exprNegTerm.struct=TabEx.intType;
	}
	
	@Override
	public void visit(AddopTermList addopTermList) {
		Struct termType=addopTermList.getTerm().struct;
		String termTypeName=structToString(termType);
		if(termType!=TabEx.intType) {
			addopTermList.struct=TabEx.noType;
			report_error("Can't perform math operations on a term (type: "+termTypeName+") in the chain.",addopTermList);
			return;
		}
		addopTermList.struct=TabEx.intType;
	}
	
	@Override
	public void visit(EmptyAddopTermList emptyAddopTermList) {
		emptyAddopTermList.struct=TabEx.noType;
	}
	
	@Override
	public void visit(ExprQQ exprQQ) {
		Struct termType=exprQQ.getTerm().struct;
		Struct exprType=exprQQ.getExpr().struct;
		String termTypeName=structToString(termType);
		String exprTypeName=structToString(exprType);
		if(termType!=TabEx.intType || exprType!=TabEx.intType) {
			exprQQ.struct=TabEx.noType;
			report_error("Can't use ?? operator on types "+termTypeName+" and "+exprTypeName+"!",exprQQ);
			return;
		}
		exprQQ.struct=TabEx.intType;
	}
	
	@Override
	public void visit(ExprNegQQ exprNegQQ) {
		Struct termType=exprNegQQ.getTerm().struct;
		Struct exprType=exprNegQQ.getExpr().struct;
		String termTypeName=structToString(termType);
		String exprTypeName=structToString(exprType);
		if(termType!=TabEx.intType || exprType!=TabEx.intType) {
			exprNegQQ.struct=TabEx.noType;
			report_error("Can't use ?? operator on types "+termTypeName+" and "+exprTypeName+"!",exprNegQQ);
			return;
		}
		exprNegQQ.struct=TabEx.intType;
	}
	
	/* ====================== Designator Statement ====================== */
	
	@Override
	public void visit(DesignatorStatementAssign designatorStatementAssign) {
		Struct destType=designatorStatementAssign.getDesignator().obj.getType();
		int destKind=designatorStatementAssign.getDesignator().obj.getKind();
		Struct srcType=designatorStatementAssign.getExpr().struct;

		if(destKind!=Obj.Var && destKind!=Obj.Elem && destKind!=Obj.Fld) {
			report_error("Left side of assignment can't be a "+kindToString(destKind)+".",designatorStatementAssign);
			return;
		}
		
		if(srcType.assignableTo(destType)==false) {
			report_error("Left and right side of the assignment aren't of the same type!",designatorStatementAssign);
			return;
		}
	}
	
	@Override
	public void visit(DesignatorStatementPostInc designatorStatementPostInc) {
		Struct destType=designatorStatementPostInc.getDesignator().obj.getType();
		int destKind=designatorStatementPostInc.getDesignator().obj.getKind();
		
		if(destKind!=Obj.Var && destKind!=Obj.Elem && destKind!=Obj.Fld) {
			report_error("Increment can't be performed on a "+kindToString(destKind)+".",designatorStatementPostInc);
			return;
		}
		
		if(destType!=TabEx.intType) {
			report_error("Increment can't be performed on type "+structToString(destType)+".",designatorStatementPostInc);
			return;
		}
	}
	
	public void visit(DesignatorStatementPostDec designatorStatementPostDec) {
		Struct desType=designatorStatementPostDec.getDesignator().obj.getType();
		int desKind=designatorStatementPostDec.getDesignator().obj.getKind();
		
		if(desKind!=Obj.Var && desKind!=Obj.Elem && desKind!=Obj.Fld) {
			report_error("Decrement can't be performed on a "+kindToString(desKind)+".",designatorStatementPostDec);
			return;
		}
		
		if(desType!=TabEx.intType) {
			report_error("Decrement can't be performed on type "+structToString(desType)+".",designatorStatementPostDec);
			return;
		}
	}
	
	/* ====================== SingleStatement ====================== */
	
	@Override
	public void visit(SingleStatementRead singleStatementRead) {
		Struct desType=singleStatementRead.getDesignator().obj.getType();
		int desKind=singleStatementRead.getDesignator().obj.getKind();
		
		if(desKind!=Obj.Var && desKind!=Obj.Elem && desKind!=Obj.Fld) {
			report_error("Can't read into a "+kindToString(desKind)+".",singleStatementRead);
			return;
		}
		
		if(desType!=TabEx.intType && desType!=TabEx.charType && desType!=TabEx.boolType) {
			report_error("Can't read into type "+structToString(desType)+".",singleStatementRead);
			return;
		}
	}
	
	@Override
	public void visit(SingleStatementPrint singleStatementPrint) {
		Struct exprType=singleStatementPrint.getExpr().struct;
		String exprTypeName=structToString(exprType);
		if(exprType!=TabEx.intType && exprType!=TabEx.charType && exprType!=TabEx.boolType) {
			report_error("Expression in print statement can't be of type "+exprTypeName+".",singleStatementPrint);
			return;
		}
	}
	
	/* ====================== Methods ====================== */

	
	

}