// generated with ast extension for cup
// version 0.8
// 30/6/2022 12:34:55


package src.rs.ac.bg.etf.pp1.ast;

public class CharConst extends Constant {

    private Character char;

    public CharConst (Character char) {
        this.char=char;
    }

    public Character getChar() {
        return char;
    }

    public void setChar(Character char) {
        this.char=char;
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
        buffer.append("CharConst(\n");

        buffer.append(" "+tab+char);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConst]");
        return buffer.toString();
    }
}
