// generated with ast extension for cup
// version 0.8
// 11/7/2022 8:54:1


package rs.ac.bg.etf.pp1.ast;

public class ClassExtendsYes extends ClassExtendsOptional {

    private ClassParentType ClassParentType;

    public ClassExtendsYes (ClassParentType ClassParentType) {
        this.ClassParentType=ClassParentType;
        if(ClassParentType!=null) ClassParentType.setParent(this);
    }

    public ClassParentType getClassParentType() {
        return ClassParentType;
    }

    public void setClassParentType(ClassParentType ClassParentType) {
        this.ClassParentType=ClassParentType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassParentType!=null) ClassParentType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassParentType!=null) ClassParentType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassParentType!=null) ClassParentType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassExtendsYes(\n");

        if(ClassParentType!=null)
            buffer.append(ClassParentType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassExtendsYes]");
        return buffer.toString();
    }
}
