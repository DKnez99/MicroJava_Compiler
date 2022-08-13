package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc=-1;	//main() start address
	// private int dataSize;
	
	public int getMainPc() {
		return mainPc;
	}
//	public int getDataSize() {
//		return dataSize;
//	}
	
	

}
