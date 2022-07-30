// generated with ast extension for cup
// version 0.8
// 30/6/2022 17:7:56


package src.rs.ac.bg.etf.pp1.ast;

public class MulopFactorList extends MulopFactorListNullable {

    private MulopFactorListNullable MulopFactorListNullable;
    private Mulop Mulop;
    private Factor Factor;

    public MulopFactorList (MulopFactorListNullable MulopFactorListNullable, Mulop Mulop, Factor Factor) {
        this.MulopFactorListNullable=MulopFactorListNullable;
        if(MulopFactorListNullable!=null) MulopFactorListNullable.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public MulopFactorListNullable getMulopFactorListNullable() {
        return MulopFactorListNullable;
    }

    public void setMulopFactorListNullable(MulopFactorListNullable MulopFactorListNullable) {
        this.MulopFactorListNullable=MulopFactorListNullable;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopFactorListNullable!=null) MulopFactorListNullable.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactorListNullable!=null) MulopFactorListNullable.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactorListNullable!=null) MulopFactorListNullable.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactorList(\n");

        if(MulopFactorListNullable!=null)
            buffer.append(MulopFactorListNullable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactorList]");
        return buffer.toString();
    }
}
