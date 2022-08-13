// generated with ast extension for cup
// version 0.8
// 13/7/2022 19:3:45


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyMethodsNo extends ClassBodyMethodsOptional {

    public ClassBodyMethodsNo () {
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
        buffer.append("ClassBodyMethodsNo(\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyMethodsNo]");
        return buffer.toString();
    }
}
