// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class DesignatorClassEntity extends Designator {

    private Designator Designator;
    private String classField;

    public DesignatorClassEntity (Designator Designator, String classField) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.classField=classField;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField=classField;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorClassEntity(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+classField);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorClassEntity]");
        return buffer.toString();
    }
}
