// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class EmptyProgramDeclList extends ProgramDeclListNullable {

    public EmptyProgramDeclList () {
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
        buffer.append("EmptyProgramDeclList(\n");

        buffer.append(tab);
        buffer.append(") [EmptyProgramDeclList]");
        return buffer.toString();
    }
}
