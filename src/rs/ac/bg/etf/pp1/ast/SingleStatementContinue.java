// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class SingleStatementContinue extends SingleStatement {

    public SingleStatementContinue () {
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
        buffer.append("SingleStatementContinue(\n");

        buffer.append(tab);
        buffer.append(") [SingleStatementContinue]");
        return buffer.toString();
    }
}
