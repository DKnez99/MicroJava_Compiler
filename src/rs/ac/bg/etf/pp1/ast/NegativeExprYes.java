// generated with ast extension for cup
// version 0.8
// 7/7/2022 10:57:53


package rs.ac.bg.etf.pp1.ast;

public class NegativeExprYes extends NegativeExprOptional {

    public NegativeExprYes () {
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
        buffer.append("NegativeExprYes(\n");

        buffer.append(tab);
        buffer.append(") [NegativeExprYes]");
        return buffer.toString();
    }
}
