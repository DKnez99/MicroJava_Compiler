// generated with ast extension for cup
// version 0.8
// 12/7/2022 8:46:4


package rs.ac.bg.etf.pp1.ast;

public class SingleStatementPrint extends SingleStatement {

    private Expr Expr;
    private SingleStatementPrintNumConstOptional SingleStatementPrintNumConstOptional;

    public SingleStatementPrint (Expr Expr, SingleStatementPrintNumConstOptional SingleStatementPrintNumConstOptional) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.SingleStatementPrintNumConstOptional=SingleStatementPrintNumConstOptional;
        if(SingleStatementPrintNumConstOptional!=null) SingleStatementPrintNumConstOptional.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public SingleStatementPrintNumConstOptional getSingleStatementPrintNumConstOptional() {
        return SingleStatementPrintNumConstOptional;
    }

    public void setSingleStatementPrintNumConstOptional(SingleStatementPrintNumConstOptional SingleStatementPrintNumConstOptional) {
        this.SingleStatementPrintNumConstOptional=SingleStatementPrintNumConstOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(SingleStatementPrintNumConstOptional!=null) SingleStatementPrintNumConstOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(SingleStatementPrintNumConstOptional!=null) SingleStatementPrintNumConstOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(SingleStatementPrintNumConstOptional!=null) SingleStatementPrintNumConstOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatementPrintNumConstOptional!=null)
            buffer.append(SingleStatementPrintNumConstOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatementPrint]");
        return buffer.toString();
    }
}
