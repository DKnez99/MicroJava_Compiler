// generated with ast extension for cup
// version 0.8
// 7/7/2022 14:19:48


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private FactorDesignatorParenOptional FactorDesignatorParenOptional;

    public FactorDesignator (Designator Designator, FactorDesignatorParenOptional FactorDesignatorParenOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorDesignatorParenOptional=FactorDesignatorParenOptional;
        if(FactorDesignatorParenOptional!=null) FactorDesignatorParenOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorDesignatorParenOptional getFactorDesignatorParenOptional() {
        return FactorDesignatorParenOptional;
    }

    public void setFactorDesignatorParenOptional(FactorDesignatorParenOptional FactorDesignatorParenOptional) {
        this.FactorDesignatorParenOptional=FactorDesignatorParenOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorDesignatorParenOptional!=null) FactorDesignatorParenOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorDesignatorParenOptional!=null) FactorDesignatorParenOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorDesignatorParenOptional!=null) FactorDesignatorParenOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorDesignatorParenOptional!=null)
            buffer.append(FactorDesignatorParenOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
