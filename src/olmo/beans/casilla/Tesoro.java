package olmo.beans.casilla;

import olmo.beans.Ficha;

import java.util.List;

public class Tesoro extends Casilla {


    public Tesoro(Integer posicion, List<Ficha> ocupantes) {
        super(posicion, ocupantes);
        setTipo(5);
    }



    public void promocion(){

    }


}
