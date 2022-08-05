package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor{
	Logger log = Logger.getLogger(getClass());
	
	public void visit(ProgramName programName) {
		programName.obj=Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program program) {
		Tab.chainLocalSymbols(program.getProgramName().obj);
	}
}
