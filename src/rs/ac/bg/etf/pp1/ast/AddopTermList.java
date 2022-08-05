// generated with ast extension for cup
// version 0.8
// 5/7/2022 9:59:59


package rs.ac.bg.etf.pp1.ast;

public class AddopTermList extends AddopTermListNullable {

    private AddopTermListNullable AddopTermListNullable;
    private Addop Addop;
    private Term Term;

    public AddopTermList (AddopTermListNullable AddopTermListNullable, Addop Addop, Term Term) {
        this.AddopTermListNullable=AddopTermListNullable;
        if(AddopTermListNullable!=null) AddopTermListNullable.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public AddopTermListNullable getAddopTermListNullable() {
        return AddopTermListNullable;
    }

    public void setAddopTermListNullable(AddopTermListNullable AddopTermListNullable) {
        this.AddopTermListNullable=AddopTermListNullable;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopTermListNullable!=null) AddopTermListNullable.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTermListNullable!=null) AddopTermListNullable.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopTermList(\n");

        if(AddopTermListNullable!=null)
            buffer.append(AddopTermListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddopTermList]");
        return buffer.toString();
    }
}
