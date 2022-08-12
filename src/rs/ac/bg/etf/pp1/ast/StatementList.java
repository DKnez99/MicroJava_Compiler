// generated with ast extension for cup
// version 0.8
// 12/7/2022 8:46:4


package rs.ac.bg.etf.pp1.ast;

public class StatementList extends StatementListNullable {

    private StatementListNullable StatementListNullable;
    private Statement Statement;

    public StatementList (StatementListNullable StatementListNullable, Statement Statement) {
        this.StatementListNullable=StatementListNullable;
        if(StatementListNullable!=null) StatementListNullable.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementListNullable getStatementListNullable() {
        return StatementListNullable;
    }

    public void setStatementListNullable(StatementListNullable StatementListNullable) {
        this.StatementListNullable=StatementListNullable;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementListNullable!=null) StatementListNullable.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListNullable!=null) StatementListNullable.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListNullable!=null) StatementListNullable.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementList(\n");

        if(StatementListNullable!=null)
            buffer.append(StatementListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementList]");
        return buffer.toString();
    }
}
