// generated with ast extension for cup
// version 0.8
// 30/6/2022 17:7:56


package src.rs.ac.bg.etf.pp1.ast;

public class FactorNewType extends Factor {

    private Type Type;
    private ExprInBracketsOptional ExprInBracketsOptional;

    public FactorNewType (Type Type, ExprInBracketsOptional ExprInBracketsOptional) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprInBracketsOptional=ExprInBracketsOptional;
        if(ExprInBracketsOptional!=null) ExprInBracketsOptional.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprInBracketsOptional getExprInBracketsOptional() {
        return ExprInBracketsOptional;
    }

    public void setExprInBracketsOptional(ExprInBracketsOptional ExprInBracketsOptional) {
        this.ExprInBracketsOptional=ExprInBracketsOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprInBracketsOptional!=null) ExprInBracketsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprInBracketsOptional!=null) ExprInBracketsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprInBracketsOptional!=null) ExprInBracketsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewType(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprInBracketsOptional!=null)
            buffer.append(ExprInBracketsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewType]");
        return buffer.toString();
    }
}
