// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class FactorConstBool extends Factor {

    private Boolean boolValue;

    public FactorConstBool (Boolean boolValue) {
        this.boolValue=boolValue;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue=boolValue;
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
        buffer.append("FactorConstBool(\n");

        buffer.append(" "+tab+boolValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorConstBool]");
        return buffer.toString();
    }
}
