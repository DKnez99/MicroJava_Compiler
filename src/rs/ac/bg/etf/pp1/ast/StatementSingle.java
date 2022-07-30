// generated with ast extension for cup
// version 0.8
// 30/6/2022 11:48:22


package src.rs.ac.bg.etf.pp1.ast;

public class StatementSingle extends Statement {

    private StatementLabelOptional StatementLabelOptional;
    private SingleStatement SingleStatement;

    public StatementSingle (StatementLabelOptional StatementLabelOptional, SingleStatement SingleStatement) {
        this.StatementLabelOptional=StatementLabelOptional;
        if(StatementLabelOptional!=null) StatementLabelOptional.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
    }

    public StatementLabelOptional getStatementLabelOptional() {
        return StatementLabelOptional;
    }

    public void setStatementLabelOptional(StatementLabelOptional StatementLabelOptional) {
        this.StatementLabelOptional=StatementLabelOptional;
    }

    public SingleStatement getSingleStatement() {
        return SingleStatement;
    }

    public void setSingleStatement(SingleStatement SingleStatement) {
        this.SingleStatement=SingleStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementLabelOptional!=null) StatementLabelOptional.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementLabelOptional!=null) StatementLabelOptional.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementLabelOptional!=null) StatementLabelOptional.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementSingle(\n");

        if(StatementLabelOptional!=null)
            buffer.append(StatementLabelOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatement!=null)
            buffer.append(SingleStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementSingle]");
        return buffer.toString();
    }
}
