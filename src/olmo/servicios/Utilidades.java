package olmo.servicios;

import olmo.beans.Ficha;
import olmo.beans.Jugador;
import olmo.beans.Tablero;
import olmo.beans.casilla.Casa;
import olmo.beans.casilla.Casilla;
import olmo.beans.casilla.Roseta;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilidades {

	public Integer tirarDados() {
		Integer n;
		Integer resul = 0;
		for (int i = 0; i < 4; i++) {
			Random r = new Random();
			n = r.nextInt(4);
			switch (n) {
			case 0:
			case 1:
				resul += 0;
				break;

			case 2:
			case 3:
				resul++;
				break;

			}
		}

		return resul;
	}

	public List<Ficha> generarFichas(Boolean color) {
		Ficha f;
		List<Ficha> listaFichas = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			f = new Ficha(false, 0, true, color);
			listaFichas.add(f);
		}

		return listaFichas;
	}

	public List<Casilla> generarRecorrido(int recorrido) {
		Casilla c;
		List<Ficha> lista ;
		List<Casilla> listaCasillas = new ArrayList<>();
		switch (recorrido) {
		/**
		 * Recorrido sencillo 1-3 Casa
		 *  4,8,14 Roseta 
		 *  4-6, 8-12 Casa
		 */
		case 1:
			c = new Casilla(0,  lista = new ArrayList<>());
			listaCasillas.add(c);
			
			c = new Casa(1,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(2,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(3,  lista = new ArrayList<>());
			listaCasillas.add(c);

			/* ROSETA */
			c = new Roseta(4,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(5,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(6,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(7,  lista = new ArrayList<>());
			listaCasillas.add(c);

			/* ROSETA */
			c = new Roseta(8,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(9,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(10,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(11,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(12,  lista = new ArrayList<>());
			listaCasillas.add(c);

			c = new Casa(13,  lista = new ArrayList<>());
			listaCasillas.add(c);

			/* ROSETA */
			c = new Roseta(14,  lista = new ArrayList<>());
			listaCasillas.add(c);

			break;
		}

		return listaCasillas;
	}
	
	public Boolean evaluarDestino(Jugador j1,List<Casilla> recorrido1,List<Casilla> recorrido2,Integer tirada, Integer ficha) {
		
		Ficha f = j1.getFichas().get(ficha);
		Integer posicion = f.getPosicion();
		Integer destino=posicion+tirada;
		Boolean ocupantes =true , ocupantes2=true;
		
		if(destino < 15) {
			ocupantes =  recorrido1.get(destino).getOcupantes().isEmpty();
			ocupantes2 =  recorrido2.get(destino).getOcupantes().isEmpty();
		}else if(destino == 15) {
			f.setEnJuego(false);
			System.out.println("Ficha en casa");
			recorrido1.get(f.getPosicion()).getOcupantes().remove(recorrido1.get(f.getPosicion()).getOcupantes().size()-1);
			f.setPosicion(destino);
			return true;
			
		}else {
			System.out.println("Esta fuera de limites , eres un terrorista");
			return false;
		}
		
		if (!ocupantes) {
			/*ocupada, devuelve fasle*/
			System.out.println("Esta ocupada, eres un terrorista");
			System.out.println("Elige otra anda");
			return ocupantes;
		}else if(!ocupantes2 && recorrido2.get(destino).getTipo()==1 ) {
			System.out.println("Roseta Ocupada, eres un terrorista");
			return ocupantes2;
		}
		/*libre devuelve true*/
		return ocupantes;
		
	}
	
	/**
	 * @param j1        jugador que juega el turno
	 * @param j2        El otro jugador
	 * @param tablero   tablero de juego
	 * @param ficha     ficha elegida para moverse
	 * @param tirada    numero que ha salido en los dados
	 * @param recorrido recorrido que se esta jugando, el del j1
	 */
	public Boolean moverFicha(Jugador j1, Jugador j2, Integer ficha, Integer tirada,
			List<Casilla> recorrido1,List<Casilla> recorrido2) {
		Ficha f = j1.getFichas().get(ficha);
 		System.out.println(f);
		Integer posicion = f.getPosicion();
		Boolean ocupantes =true, ocupantes2 = true, roseta=false;
		Integer destino=posicion+tirada;
			
		
		if(destino<15) {
		/*ocupantes del destino del mismo color*/
		//Integer ocupantes = recorrido1.get(destino).getOcupantes().size();
		 ocupantes =  recorrido1.get(destino).getOcupantes().isEmpty();
		 ocupantes2 =  recorrido2.get(destino).getOcupantes().isEmpty();
		//comerFicha(posicion, j2.getFichas());
		
		
		
		if (!ocupantes) {
			System.out.println("Esta ocupada, eres un terrorista");
			System.out.println("Elige otra anda");
			
		 }else if(destino>4 && destino<12 && !ocupantes2) {
			 
			 comerFicha(destino, j2.getFichas() ,recorrido2);
			 
			 System.out.println("La ficha se vuelve a mover");
			 if (posicion == 0) {
					System.out.println("La ficha entra en el tablero");
					f.setPosicion(tirada);
					recorrido1.get(f.getPosicion()).getOcupantes().add(f);
					System.out.println(recorrido1.get(f.getPosicion()).getPosicion());
				} else if(posicion > 0){
					System.out.println("La ficha se vuelve a mover");
					recorrido1.get(f.getPosicion()).getOcupantes().remove(recorrido1.get(f.getPosicion()).getOcupantes().size()-1);
					f.setPosicion(destino);
					recorrido1.get(f.getPosicion()).getOcupantes().add(f);
				}
			 
			 
		} else if (ocupantes) {
			/*movimiento normal*/
		
			if(recorrido1.get(destino).getTipo()==1) {
				roseta = true;
				System.out.println("Consigues un turno extra!!!!!");
			}else {
				roseta = false;
			}
			if (posicion == 0) {
				System.out.println("La ficha entra en el tablero");
				f.setPosicion(tirada);
				recorrido1.get(f.getPosicion()).getOcupantes().add(f);
				System.out.println(recorrido1.get(f.getPosicion()).getPosicion());
			} else if(posicion > 0){
				System.out.println("La ficha se vuelve a mover");
				recorrido1.get(f.getPosicion()).getOcupantes().remove(recorrido1.get(f.getPosicion()).getOcupantes().size()-1);
				f.setPosicion(destino);
				recorrido1.get(f.getPosicion()).getOcupantes().add(f);
			}
		}
		
		}
		return roseta;

	}

	public void comerFicha(Integer destino, List<Ficha> lista , List<Casilla> listaCasillas) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getPosicion() == destino) {
				lista.get(i).setPosicion(0);
				listaCasillas.get(destino).getOcupantes().remove(listaCasillas.get(destino).getOcupantes().size()-1);
				System.out.println("Pa tu casa neno");
			}
		}
	}
}
