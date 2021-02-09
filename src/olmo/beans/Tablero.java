package olmo.beans;

import olmo.beans.casilla.Casilla;
import olmo.beans.casilla.Roseta;

import java.util.ArrayList;
import java.util.List;

public class Tablero {


    private List<Casilla> recorridoNegro;
    private List<Casilla> recorridoBlanco;

    public Tablero() {
    this.recorridoNegro= new ArrayList<>();
    this. recorridoBlanco =new ArrayList<>();
    }

    public List<Casilla> getRecorridoNegro() {
        return recorridoNegro;
    }

    public void setRecorridoNegro(List<Casilla> recorridoNegro) {
        this.recorridoNegro = recorridoNegro;
    }

    public List<Casilla> getRecorridoBlanco() {
        return recorridoBlanco;
    }

    public void setRecorridoBlanco(List<Casilla> recorridoBlanco) {
        this.recorridoBlanco = recorridoBlanco;
    }
}
