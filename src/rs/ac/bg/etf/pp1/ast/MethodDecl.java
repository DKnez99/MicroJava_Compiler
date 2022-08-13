// generated with ast extension for cup
// version 0.8
// 13/7/2022 19:3:45


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodReturnType MethodReturnType;
    private MethodName MethodName;
    private FormParsOptional FormParsOptional;
    private VarDeclListNullable VarDeclListNullable;
    private StatementListNullable StatementListNullable;

    public MethodDecl (MethodReturnType MethodReturnType, MethodName MethodName, FormParsOptional FormParsOptional, VarDeclListNullable VarDeclListNullable, StatementListNullable StatementListNullable) {
        this.MethodReturnType=MethodReturnType;
        if(MethodReturnType!=null) MethodReturnType.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.FormParsOptional=FormParsOptional;
        if(FormParsOptional!=null) FormParsOptional.setParent(this);
        this.VarDeclListNullable=VarDeclListNullable;
        if(VarDeclListNullable!=null) VarDeclListNullable.setParent(this);
        this.StatementListNullable=StatementListNullable;
        if(StatementListNullable!=null) StatementListNullable.setParent(this);
    }

    public MethodReturnType getMethodReturnType() {
        return MethodReturnType;
    }

    public void setMethodReturnType(MethodReturnType MethodReturnType) {
        this.MethodReturnType=MethodReturnType;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public FormParsOptional getFormParsOptional() {
        return FormParsOptional;
    }

    public void setFormParsOptional(FormParsOptional FormParsOptional) {
        this.FormParsOptional=FormParsOptional;
    }

    public VarDeclListNullable getVarDeclListNullable() {
        return VarDeclListNullable;
    }

    public void setVarDeclListNullable(VarDeclListNullable VarDeclListNullable) {
        this.VarDeclListNullable=VarDeclListNullable;
    }

    public StatementListNullable getStatementListNullable() {
        return StatementListNullable;
    }

    public void setStatementListNullable(StatementListNullable StatementListNullable) {
        this.StatementListNullable=StatementListNullable;
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
        if(MethodReturnType!=null) MethodReturnType.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(FormParsOptional!=null) FormParsOptional.accept(visitor);
        if(VarDeclListNullable!=null) VarDeclListNullable.accept(visitor);
        if(StatementListNullable!=null) StatementListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnType!=null) MethodReturnType.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseTopDown(visitor);
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseTopDown(visitor);
        if(StatementListNullable!=null) StatementListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseBottomUp(visitor);
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseBottomUp(visitor);
        if(StatementListNullable!=null) StatementListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodReturnType!=null)
            buffer.append(MethodReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsOptional!=null)
            buffer.append(FormParsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListNullable!=null)
            buffer.append(VarDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementListNullable!=null)
            buffer.append(StatementListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
