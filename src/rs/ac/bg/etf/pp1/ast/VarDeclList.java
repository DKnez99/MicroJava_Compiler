// generated with ast extension for cup
// version 0.8
// 30/6/2022 11:48:22


package src.rs.ac.bg.etf.pp1.ast;

public class VarDeclList extends VarDeclListNullable {

    private VarDeclListNullable VarDeclListNullable;
    private VarDecl VarDecl;

    public VarDeclList (VarDeclListNullable VarDeclListNullable, VarDecl VarDecl) {
        this.VarDeclListNullable=VarDeclListNullable;
        if(VarDeclListNullable!=null) VarDeclListNullable.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarDeclListNullable getVarDeclListNullable() {
        return VarDeclListNullable;
    }

    public void setVarDeclListNullable(VarDeclListNullable VarDeclListNullable) {
        this.VarDeclListNullable=VarDeclListNullable;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclListNullable!=null) VarDeclListNullable.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListNullable!=null) VarDeclListNullable.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(VarDeclListNullable!=null)
            buffer.append(VarDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
