// generated with ast extension for cup
// version 0.8
// 31/6/2022 8:35:41


package rs.ac.bg.etf.pp1.ast;

public class ActParsNo extends ActParsOptional {

    public ActParsNo () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsNo(\n");

        buffer.append(tab);
        buffer.append(") [ActParsNo]");
        return buffer.toString();
    }
}
