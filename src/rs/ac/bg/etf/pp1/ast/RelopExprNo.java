// generated with ast extension for cup
// version 0.8
// 12/7/2022 8:46:4


package rs.ac.bg.etf.pp1.ast;

public class RelopExprNo extends RelopExprOptional {

    public RelopExprNo () {
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
        buffer.append("RelopExprNo(\n");

        buffer.append(tab);
        buffer.append(") [RelopExprNo]");
        return buffer.toString();
    }
}
