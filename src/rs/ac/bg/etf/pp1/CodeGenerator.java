package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected=false;
	private boolean termAlreadyNegated=false;
	private int mainPc=-1;	//main() start address
	// private int dataSize;
	
	public int getMainPc() {
		return mainPc;
	}
//	public int getDataSize() {
//		return dataSize;
//	}
	
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
	/* ==================== Single Statements ==================== */
	
	@Override
	public void visit(SingleStatementRead singleStatementRead) {
		if(singleStatementRead.getDesignator().obj.getType()==TabEx.charType) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		Code.store(singleStatementRead.getDesignator().obj);
	}
	
	@Override
	public void visit(SingleStatementPrint singleStatementPrint) {
		//expr is already on the stack here
		Code.loadConst(1);
		if(singleStatementPrint.getExpr().struct==TabEx.charType) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(SingleStatementPrintWithNumber singleStatementPrintWithNumber) {
		//expr is already on the stack here
		Code.loadConst(singleStatementPrintWithNumber.getPrintNumber());
		if(singleStatementPrintWithNumber.getExpr().struct==TabEx.charType) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(SingleStatementReturn singleStatementReturn) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* ==================== Methods ==================== */
	
	@Override
	public void visit(MethodName methodName) {	//enter method
		methodName.obj.setAdr(Code.pc);	//set method addr to current pc
		if(methodName.getMethodName().equals("main")) {
			mainPc=Code.pc;
		}
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel());
		Code.put(methodName.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {	//exit method
		//check here for runtime error if actual return type doesn't match method's return type
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* ==================== Designators ==================== */
	
	@Override
	public void visit(DesignatorArray designatorArray) {
		Code.load(designatorArray.getDesignator().obj); //array addr
		Code.put(Code.dup_x1);	//put arr addr also beneath index el
		Code.put(Code.pop);	//remove extra arr addr
	}
	
	/* ==================== Terms ==================== */
	
	@Override
	public void visit(Term term) {
		if((term.getParent() instanceof ExprNegTerm || term.getParent() instanceof ExprNegQQ) && termAlreadyNegated==false) {
			//report_info("STACK NEGATED!",term);
			termAlreadyNegated=true;
			Code.put(Code.neg);
		}
	}
	
	@Override
	public void visit(AddopTermList addopTermList) {
		if(addopTermList.getAddop() instanceof Plus) {
			Code.put(Code.add);
		}
		else if(addopTermList.getAddop() instanceof Minus){
			Code.put(Code.sub);
		}
	}
	/* ==================== Expr ==================== */
	
	@Override
	public void visit(ExprNegTerm e) {
		termAlreadyNegated=false;
	}
	
	@Override
	public void visit(ExprNegQQ e) {
		termAlreadyNegated=false;
	}
	
	/* ==================== Factors ==================== */
	@Override
	public void visit(MulopFactorList mulopFactorList) {
		if(mulopFactorList.getMulop() instanceof Mul) {
			Code.put(Code.mul);
		}
		else if(mulopFactorList.getMulop() instanceof Div) {
			Code.put(Code.div);
		}
		else if(mulopFactorList.getMulop() instanceof Mod) {
			Code.put(Code.rem);
		}
	}
	
	@Override
	public void visit(FactorConstNum factorConstNum) {
		//create dummy obj so load function will take care of calculating which Code method needs to be called
		Obj numConst=TabEx.insert(Obj.Con, "$", TabEx.intType);
		numConst.setLevel(0);
		numConst.setAdr(factorConstNum.getNumberValue());
		Code.load(numConst);
	}
	
	@Override
	public void visit(FactorConstChar factorConstChar) {
		//create dummy obj so load function will take care of calculating which Code method needs to be called
		Obj charConst=TabEx.insert(Obj.Con, "$", TabEx.charType);
		charConst.setLevel(0);
		charConst.setAdr(factorConstChar.getCharValue());
		Code.load(charConst);
	}
	
	@Override
	public void visit(FactorConstBool factorConstBool) {
		//create dummy obj so load function will take care of calculating which Code method needs to be called
		Obj boolConst=TabEx.insert(Obj.Con, "$", TabEx.boolType);
		boolConst.setLevel(0);
		boolConst.setAdr(((factorConstBool.getBoolValue()==true)?1:0));
		Code.load(boolConst);
	}
	
	@Override
	public void visit(FactorDesignator factorDesignator) {
		//put designator value on stack
		Code.load(factorDesignator.getDesignator().obj);
	}
	
	@Override
	public void visit(FactorNewArray factorNewArray) {
		//number of elements is already on the stack
		Code.put(Code.newarray);
		//put type of element on the stack (0 for char, 1 for bool and int)
		Code.put(((factorNewArray.struct.getElemType()==TabEx.charType)?0:1));
	}
	/* ==================== Factors ==================== */
	
	@Override
	public void visit(DesignatorStatementAssign designatorStatementAssign) {
		Code.store(designatorStatementAssign.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatementPostInc designatorStatementPostInc) {
		Obj designator=designatorStatementPostInc.getDesignator().obj;
		//check if designator is an array element
		if(designator.getKind()==Obj.Elem) {
			Code.put(Code.dup2);//duplicate arrays address and index of element we are accessing to avoid underflow
		}
		Code.load(designator); //load value on stack
		Code.loadConst(1);
		Code.put(Code.add);	//removes 1 and object value, and puts object value + 1 on stack
		Code.store(designator); //cleans the stack and calls correct store/put method depending on object
	}
	
	@Override
	public void visit(DesignatorStatementPostDec designatorStatementPostDec) {
		Obj designator=designatorStatementPostDec.getDesignator().obj;
		//check if designator is an array element
		if(designator.getKind()==Obj.Elem) {
			Code.put(Code.dup2);//duplicate arrays address and index of element we are accessing to avoid underflow
		}
		Code.load(designator); //load value on stack
		Code.loadConst(1);
		Code.put(Code.sub);	//removes 1 and object value, and puts object value - 1 on stack
		Code.store(designator); //cleans the stack and calls correct store/put method depending on object
	}
}
