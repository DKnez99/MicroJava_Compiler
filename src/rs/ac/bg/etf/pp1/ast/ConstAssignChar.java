// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignChar extends ConstAssign {

    private String constName;
    private Character charValue;

    public ConstAssignChar (String constName, Character charValue) {
        this.constName=constName;
        this.charValue=charValue;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Character getCharValue() {
        return charValue;
    }

    public void setCharValue(Character charValue) {
        this.charValue=charValue;
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
        buffer.append("ConstAssignChar(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+charValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignChar]");
        return buffer.toString();
    }
}
