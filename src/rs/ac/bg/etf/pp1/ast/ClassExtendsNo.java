// generated with ast extension for cup
// version 0.8
// 30/6/2022 12:34:55


package src.rs.ac.bg.etf.pp1.ast;

public class ClassExtendsNo extends ClassExtendsOptional {

    public ClassExtendsNo () {
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
        buffer.append("ClassExtendsNo(\n");

        buffer.append(tab);
        buffer.append(") [ClassExtendsNo]");
        return buffer.toString();
    }
}