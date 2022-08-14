// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class ClassBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDeclListNullable VarDeclListNullable;
    private ClassBodyMethodsOptional ClassBodyMethodsOptional;

    public ClassBody (VarDeclListNullable VarDeclListNullable, ClassBodyMethodsOptional ClassBodyMethodsOptional) {
        this.VarDeclListNullable=VarDeclListNullable;
        if(VarDeclListNullable!=null) VarDeclListNullable.setParent(this);
        this.ClassBodyMethodsOptional=ClassBodyMethodsOptional;
        if(ClassBodyMethodsOptional!=null) ClassBodyMethodsOptional.setParent(this);
    }

    public VarDeclListNullable getVarDeclListNullable() {
        return VarDeclListNullable;
    }

    public void setVarDeclListNullable(VarDeclListNullable VarDeclListNullable) {
        this.VarDeclListNullable=VarDeclListNullable;
    }

    public ClassBodyMethodsOptional getClassBodyMethodsOptional() {
        return ClassBodyMethodsOptional;
    }

    public void setClassBodyMethodsOptional(ClassBodyMethodsOptional ClassBodyMethodsOptional) {
        this.ClassBodyMethodsOptional=ClassBodyMethodsOptional;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclListNullable!=null) VarDeclListNullable.accept(visitor);
        if(ClassBodyMethodsOptional!=null) ClassBodyMethodsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseTopDown(visitor);
        if(ClassBodyMethodsOptional!=null) ClassBodyMethodsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseBottomUp(visitor);
        if(ClassBodyMethodsOptional!=null) ClassBodyMethodsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBody(\n");

        if(VarDeclListNullable!=null)
            buffer.append(VarDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassBodyMethodsOptional!=null)
            buffer.append(ClassBodyMethodsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBody]");
        return buffer.toString();
    }
}
