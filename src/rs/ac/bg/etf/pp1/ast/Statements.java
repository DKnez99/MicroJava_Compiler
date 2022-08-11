// generated with ast extension for cup
// version 0.8
// 11/7/2022 8:54:1


package rs.ac.bg.etf.pp1.ast;

public class Statements implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private StatementListNullable StatementListNullable;

    public Statements (StatementListNullable StatementListNullable) {
        this.StatementListNullable=StatementListNullable;
        if(StatementListNullable!=null) StatementListNullable.setParent(this);
    }

    public StatementListNullable getStatementListNullable() {
        return StatementListNullable;
    }

    public void setStatementListNullable(StatementListNullable StatementListNullable) {
        this.StatementListNullable=StatementListNullable;
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
        if(StatementListNullable!=null) StatementListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListNullable!=null) StatementListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListNullable!=null) StatementListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statements(\n");

        if(StatementListNullable!=null)
            buffer.append(StatementListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statements]");
        return buffer.toString();
    }
}
