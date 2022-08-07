// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class ExprTerm extends Expr {

    private NegativeExprOptional NegativeExprOptional;
    private Term Term;
    private AddopTermListNullable AddopTermListNullable;

    public ExprTerm (NegativeExprOptional NegativeExprOptional, Term Term, AddopTermListNullable AddopTermListNullable) {
        this.NegativeExprOptional=NegativeExprOptional;
        if(NegativeExprOptional!=null) NegativeExprOptional.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopTermListNullable=AddopTermListNullable;
        if(AddopTermListNullable!=null) AddopTermListNullable.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NegativeExprOptional!=null) NegativeExprOptional.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NegativeExprOptional!=null) NegativeExprOptional.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NegativeExprOptional!=null) NegativeExprOptional.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprTerm(\n");

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

        buffer.append(tab);
        buffer.append(") [ExprTerm]");
        return buffer.toString();
    }
}
