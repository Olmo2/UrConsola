package olmo.beans.casilla;

import olmo.beans.Ficha;

import java.util.List;

public class Casa extends Casilla {

    public Casa() {
        super();
        setTipo(2);
    }

    public Casa(Integer posicion, List<Ficha> ocupantes) {
        super(posicion, ocupantes);
        setTipo(2);
    }
}
