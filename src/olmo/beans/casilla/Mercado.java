package olmo.beans.casilla;

import olmo.beans.Ficha;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Mercado extends Casilla {

    /*Pila LIFO*/
    private Deque<Ficha> fichas;


    public Mercado(Integer posicion, List<Ficha> ocupantes) {
        super(posicion, ocupantes);
        fichas= new ArrayDeque<>(4);
        setTipo(4);
    }

    public Deque<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(Deque<Ficha> fichas) {
        this.fichas = fichas;
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "fichas=" + fichas +
                '}';
    }
}
