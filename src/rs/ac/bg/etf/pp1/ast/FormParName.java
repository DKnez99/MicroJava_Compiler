// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class FormParName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String formParName;

    public FormParName (String formParName) {
        this.formParName=formParName;
    }

    public String getFormParName() {
        return formParName;
    }

    public void setFormParName(String formParName) {
        this.formParName=formParName;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("FormParName(\n");

        buffer.append(" "+tab+formParName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParName]");
        return buffer.toString();
    }
}
