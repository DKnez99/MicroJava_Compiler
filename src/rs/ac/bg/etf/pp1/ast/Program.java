// generated with ast extension for cup
// version 0.8
// 5/7/2022 9:59:59


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgramName ProgramName;
    private ProgramDeclListNullable ProgramDeclListNullable;
    private MethodDeclListNullable MethodDeclListNullable;

    public Program (ProgramName ProgramName, ProgramDeclListNullable ProgramDeclListNullable, MethodDeclListNullable MethodDeclListNullable) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.ProgramDeclListNullable=ProgramDeclListNullable;
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.setParent(this);
        this.MethodDeclListNullable=MethodDeclListNullable;
        if(MethodDeclListNullable!=null) MethodDeclListNullable.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public ProgramDeclListNullable getProgramDeclListNullable() {
        return ProgramDeclListNullable;
    }

    public void setProgramDeclListNullable(ProgramDeclListNullable ProgramDeclListNullable) {
        this.ProgramDeclListNullable=ProgramDeclListNullable;
    }

    public MethodDeclListNullable getMethodDeclListNullable() {
        return MethodDeclListNullable;
    }

    public void setMethodDeclListNullable(MethodDeclListNullable MethodDeclListNullable) {
        this.MethodDeclListNullable=MethodDeclListNullable;
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
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.accept(visitor);
        if(MethodDeclListNullable!=null) MethodDeclListNullable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.traverseTopDown(visitor);
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(ProgramDeclListNullable!=null) ProgramDeclListNullable.traverseBottomUp(visitor);
        if(MethodDeclListNullable!=null) MethodDeclListNullable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDeclListNullable!=null)
            buffer.append(ProgramDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclListNullable!=null)
            buffer.append(MethodDeclListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
