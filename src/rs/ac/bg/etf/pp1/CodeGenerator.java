package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected=false;
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
		Code.put(Code.read);
		Code.store(singleStatementRead.getDesignator().obj);
	}
	
	@Override
	public void visit(SingleStatementPrint singleStatementPrint) {
		if(singleStatementPrint.getExpr().struct==TabEx.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(SingleStatementPrintWithNumber singleStatementPrintWithNumber) {
		Code.loadConst(singleStatementPrintWithNumber.getPrintNumber());
		if(singleStatementPrintWithNumber.getExpr().struct==TabEx.charType) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
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
}
