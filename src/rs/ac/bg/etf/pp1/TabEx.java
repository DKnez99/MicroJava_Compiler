package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class TabEx extends Tab {

	public static final Struct boolType = new Struct(Struct.Bool);
	private static int currentLevel; // current scope depth level
	
	public static void init() {
		Tab.init();
		Obj boolObj=new Obj(Obj.Type, "bool", boolType);
		Tab.currentScope.addToLocals(boolObj);
		TabEx.currentScope.addToLocals(boolObj);
		currentLevel=-1;
	}
	
	public static void dump(SymbolTableVisitor stv) {
		if (stv == null)
			stv = new DumpSymbolTableVisitor();
		for (Scope s = currentScope; s != null; s = s.getOuter()) {
			s.accept(stv);
		}
		System.out.println(stv.getOutput());
	}
	
	/* Print symbol table */
	public static void dump() {
		dump(null);
	}
}
