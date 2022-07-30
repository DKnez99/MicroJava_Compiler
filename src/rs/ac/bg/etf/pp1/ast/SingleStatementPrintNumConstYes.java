// generated with ast extension for cup
// version 0.8
// 30/6/2022 12:34:55


package src.rs.ac.bg.etf.pp1.ast;

public class SingleStatementPrintNumConstYes extends SingleStatementPrintNumConstOptional {

    private Integer printNumber;

    public SingleStatementPrintNumConstYes (Integer printNumber) {
        this.printNumber=printNumber;
    }

    public Integer getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(Integer printNumber) {
        this.printNumber=printNumber;
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
        buffer.append("SingleStatementPrintNumConstYes(\n");

        buffer.append(" "+tab+printNumber);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatementPrintNumConstYes]");
        return buffer.toString();
    }
}
