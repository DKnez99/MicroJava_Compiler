// generated with ast extension for cup
// version 0.8
// 11/7/2022 8:54:1


package rs.ac.bg.etf.pp1.ast;

public class ExprNegTerm extends Expr {

    private Term Term;
    private AddopTermListNullable AddopTermListNullable;

    public ExprNegTerm (Term Term, AddopTermListNullable AddopTermListNullable) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopTermListNullable=AddopTermListNullable;
        if(AddopTermListNullable!=null) AddopTermListNullable.setParent(this);
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
        if(Term!=null) Term.accept(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprNegTerm(\n");

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
        buffer.append(") [ExprNegTerm]");
        return buffer.toString();
    }
}
