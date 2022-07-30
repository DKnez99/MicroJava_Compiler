// generated with ast extension for cup
// version 0.8
// 30/6/2022 12:34:55


package src.rs.ac.bg.etf.pp1.ast;

public class EmptyVarDeclListNullable extends VarDeclListNullable {

    public EmptyVarDeclListNullable () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyVarDeclListNullable(\n");

        buffer.append(tab);
        buffer.append(") [EmptyVarDeclListNullable]");
        return buffer.toString();
    }
}
