// generated with ast extension for cup
// version 0.8
// 30/6/2022 11:48:22


package src.rs.ac.bg.etf.pp1.ast;

public class Var implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarName VarName;
    private BracketsOptional BracketsOptional;

    public Var (VarName VarName, BracketsOptional BracketsOptional) {
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
        this.BracketsOptional=BracketsOptional;
        if(BracketsOptional!=null) BracketsOptional.setParent(this);
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public BracketsOptional getBracketsOptional() {
        return BracketsOptional;
    }

    public void setBracketsOptional(BracketsOptional BracketsOptional) {
        this.BracketsOptional=BracketsOptional;
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
        if(VarName!=null) VarName.accept(visitor);
        if(BracketsOptional!=null) BracketsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
        if(BracketsOptional!=null) BracketsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        if(BracketsOptional!=null) BracketsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Var(\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BracketsOptional!=null)
            buffer.append(BracketsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Var]");
        return buffer.toString();
    }
}
