// generated with ast extension for cup
// version 0.8
// 12/7/2022 8:46:4


package rs.ac.bg.etf.pp1.ast;

public class SingleStatementIf extends SingleStatement {

    private Condition Condition;
    private Statement Statement;
    private SingleStatementElseOptional SingleStatementElseOptional;

    public SingleStatementIf (Condition Condition, Statement Statement, SingleStatementElseOptional SingleStatementElseOptional) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.SingleStatementElseOptional=SingleStatementElseOptional;
        if(SingleStatementElseOptional!=null) SingleStatementElseOptional.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public SingleStatementElseOptional getSingleStatementElseOptional() {
        return SingleStatementElseOptional;
    }

    public void setSingleStatementElseOptional(SingleStatementElseOptional SingleStatementElseOptional) {
        this.SingleStatementElseOptional=SingleStatementElseOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(SingleStatementElseOptional!=null) SingleStatementElseOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(SingleStatementElseOptional!=null) SingleStatementElseOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(SingleStatementElseOptional!=null) SingleStatementElseOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatementIf(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatementElseOptional!=null)
            buffer.append(SingleStatementElseOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatementIf]");
        return buffer.toString();
    }
}
