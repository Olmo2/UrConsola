package olmo.beans.casilla;

import olmo.beans.Ficha;

import java.util.List;

public class Roseta extends Casilla {

    public Roseta() {
        super();
        setTipo(1);
    }

    public Roseta(Integer posicion, List<Ficha> ocupantes) {
        super(posicion, ocupantes);
        setTipo(1);
    }

    public void repetirTurno(){

    }



}
