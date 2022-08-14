// generated with ast extension for cup
// version 0.8
// 14/7/2022 13:18:50


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclList extends ProgramDeclListNullable {

    private ProgramDeclListNullable ProgramDeclListNullable;
    private ProgramDecl ProgramDecl;

    public ProgramDeclList (ProgramDeclListNullable ProgramDeclListNullable, ProgramDecl ProgramDecl) {
        this.ProgramDeclListNullable=ProgramDeclListNullable;
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.setParent(this);
        this.ProgramDecl=ProgramDecl;
        if(ProgramDecl!=null) ProgramDecl.setParent(this);
    }

    public ProgramDeclListNullable getProgramDeclListNullable() {
        return ProgramDeclListNullable;
    }

    public void setProgramDeclListNullable(ProgramDeclListNullable ProgramDeclListNullable) {
        this.ProgramDeclListNullable=ProgramDeclListNullable;
    }

    public ProgramDecl getProgramDecl() {
        return ProgramDecl;
    }

    public void setProgramDecl(ProgramDecl ProgramDecl) {
        this.ProgramDecl=ProgramDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.accept(visitor);
        if(ProgramDecl!=null) ProgramDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.traverseTopDown(visitor);
        if(ProgramDecl!=null) ProgramDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.traverseBottomUp(visitor);
        if(ProgramDecl!=null) ProgramDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclList(\n");

        if(ProgramDeclListNullable!=null)
            buffer.append(ProgramDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDecl!=null)
            buffer.append(ProgramDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclList]");
        return buffer.toString();
    }
}
