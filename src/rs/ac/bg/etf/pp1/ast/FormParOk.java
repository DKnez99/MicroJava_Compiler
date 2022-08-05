// generated with ast extension for cup
// version 0.8
// 5/7/2022 9:59:59


package rs.ac.bg.etf.pp1.ast;

public class FormParOk extends FormPar {

    private FormParType FormParType;
    private FormParName FormParName;
    private BracketsOptional BracketsOptional;

    public FormParOk (FormParType FormParType, FormParName FormParName, BracketsOptional BracketsOptional) {
        this.FormParType=FormParType;
        if(FormParType!=null) FormParType.setParent(this);
        this.FormParName=FormParName;
        if(FormParName!=null) FormParName.setParent(this);
        this.BracketsOptional=BracketsOptional;
        if(BracketsOptional!=null) BracketsOptional.setParent(this);
    }

    public FormParType getFormParType() {
        return FormParType;
    }

    public void setFormParType(FormParType FormParType) {
        this.FormParType=FormParType;
    }

    public FormParName getFormParName() {
        return FormParName;
    }

    public void setFormParName(FormParName FormParName) {
        this.FormParName=FormParName;
    }

    public BracketsOptional getBracketsOptional() {
        return BracketsOptional;
    }

    public void setBracketsOptional(BracketsOptional BracketsOptional) {
        this.BracketsOptional=BracketsOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParType!=null) FormParType.accept(visitor);
        if(FormParName!=null) FormParName.accept(visitor);
        if(BracketsOptional!=null) BracketsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParType!=null) FormParType.traverseTopDown(visitor);
        if(FormParName!=null) FormParName.traverseTopDown(visitor);
        if(BracketsOptional!=null) BracketsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParType!=null) FormParType.traverseBottomUp(visitor);
        if(FormParName!=null) FormParName.traverseBottomUp(visitor);
        if(BracketsOptional!=null) BracketsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParOk(\n");

        if(FormParType!=null)
            buffer.append(FormParType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParName!=null)
            buffer.append(FormParName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BracketsOptional!=null)
            buffer.append(BracketsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParOk]");
        return buffer.toString();
    }
}
