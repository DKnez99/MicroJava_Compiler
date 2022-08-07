package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class TabEx extends Tab {
	private static int currentLevel; // nivo ugnezdavanja tekuceg opsega
	public static final Struct boolType=new Struct(Struct.Bool);
	public static void init() {
		Tab.init();
		Scope universe = Tab.currentScope;
		universe.addToLocals(new Obj(Obj.Type, "bool", boolType));
		currentLevel=-1;
	}

}
