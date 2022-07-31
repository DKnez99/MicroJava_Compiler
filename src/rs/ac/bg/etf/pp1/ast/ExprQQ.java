// generated with ast extension for cup
// version 0.8
// 31/6/2022 8:35:41


package rs.ac.bg.etf.pp1.ast;

public class ExprQQ extends Expr {

    private NegativeExprOptional NegativeExprOptional;
    private Term Term;
    private AddopTermListNullable AddopTermListNullable;
    private Expr Expr;

    public ExprQQ (NegativeExprOptional NegativeExprOptional, Term Term, AddopTermListNullable AddopTermListNullable, Expr Expr) {
        this.NegativeExprOptional=NegativeExprOptional;
        if(NegativeExprOptional!=null) NegativeExprOptional.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopTermListNullable=AddopTermListNullable;
        if(AddopTermListNullable!=null) AddopTermListNullable.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public NegativeExprOptional getNegativeExprOptional() {
        return NegativeExprOptional;
    }

    public void setNegativeExprOptional(NegativeExprOptional NegativeExprOptional) {
        this.NegativeExprOptional=NegativeExprOptional;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddopTermListNullable getAddopTermListNullable() {
        return AddopTermListNullable;
    }

    public void setAddopTermListNullable(AddopTermListNullable AddopTermListNullable) {
        this.AddopTermListNullable=AddopTermListNullable;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NegativeExprOptional!=null) NegativeExprOptional.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NegativeExprOptional!=null) NegativeExprOptional.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NegativeExprOptional!=null) NegativeExprOptional.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprQQ(\n");

        if(NegativeExprOptional!=null)
            buffer.append(NegativeExprOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermListNullable!=null)
            buffer.append(AddopTermListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprQQ]");
        return buffer.toString();
    }
}
