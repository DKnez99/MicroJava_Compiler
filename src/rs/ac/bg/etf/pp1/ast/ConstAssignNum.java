// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignNum extends ConstAssign {

    private String constName;
    private Integer numberValue;

    public ConstAssignNum (String constName, Integer numberValue) {
        this.constName=constName;
        this.numberValue=numberValue;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Integer getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Integer numberValue) {
        this.numberValue=numberValue;
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
        buffer.append("ConstAssignNum(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+numberValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignNum]");
        return buffer.toString();
    }
}
