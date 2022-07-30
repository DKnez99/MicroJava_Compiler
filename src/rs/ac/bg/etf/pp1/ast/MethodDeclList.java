// generated with ast extension for cup
// version 0.8
// 30/6/2022 11:48:22


package src.rs.ac.bg.etf.pp1.ast;

public class MethodDeclList extends MethodDeclListNullable {

    private MethodDeclListNullable MethodDeclListNullable;
    private MethodDecl MethodDecl;

    public MethodDeclList (MethodDeclListNullable MethodDeclListNullable, MethodDecl MethodDecl) {
        this.MethodDeclListNullable=MethodDeclListNullable;
        if(MethodDeclListNullable!=null) MethodDeclListNullable.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public MethodDeclListNullable getMethodDeclListNullable() {
        return MethodDeclListNullable;
    }

    public void setMethodDeclListNullable(MethodDeclListNullable MethodDeclListNullable) {
        this.MethodDeclListNullable=MethodDeclListNullable;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclListNullable!=null) MethodDeclListNullable.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclList(\n");

        if(MethodDeclListNullable!=null)
            buffer.append(MethodDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclList]");
        return buffer.toString();
    }
}
