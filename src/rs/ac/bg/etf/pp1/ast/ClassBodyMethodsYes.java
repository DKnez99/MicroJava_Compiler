// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyMethodsYes extends ClassBodyMethodsOptional {

    private MethodDeclListNullable MethodDeclListNullable;

    public ClassBodyMethodsYes (MethodDeclListNullable MethodDeclListNullable) {
        this.MethodDeclListNullable=MethodDeclListNullable;
        if(MethodDeclListNullable!=null) MethodDeclListNullable.setParent(this);
    }

    public MethodDeclListNullable getMethodDeclListNullable() {
        return MethodDeclListNullable;
    }

    public void setMethodDeclListNullable(MethodDeclListNullable MethodDeclListNullable) {
        this.MethodDeclListNullable=MethodDeclListNullable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclListNullable!=null) MethodDeclListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyMethodsYes(\n");

        if(MethodDeclListNullable!=null)
            buffer.append(MethodDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyMethodsYes]");
        return buffer.toString();
    }
}
