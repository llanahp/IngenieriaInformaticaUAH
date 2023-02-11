import org.antlr.v4.runtime.tree.*;

public class Walker extends ParseTreeWalker {
    boolean sigue;
    boolean condicionWhile;
    public Walker(){
        this.sigue = true;
        this.condicionWhile=false;
    }

    @Override
    public void walk(ParseTreeListener listener, ParseTree t) {
        if ( t instanceof ErrorNode) {
            listener.visitErrorNode((ErrorNode)t);
            return;
        }
        else if ( t instanceof TerminalNode) {
            listener.visitTerminal((TerminalNode)t);
            return;
        }

        RuleNode r = (RuleNode) t;
        enterRule(listener, r);
        int n = r.getChildCount();

        for (int i = 0; i < r.getChildCount(); i++) {
            // Condición para poder parar la ejecución del árbol si por ejemplo llegamos a un if y la condición es falsa
            if(!sigue) break;
            walk(listener, r.getChild(i));
        }

        sigue = true;
        exitRule(listener, r);
    }


    public void setSigue(boolean sigue){
        this.sigue = sigue;
    }

    public void setCondicionWhile(boolean condicion){
        this.condicionWhile = condicion;
    }

}
