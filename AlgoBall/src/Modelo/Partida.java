package Modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import Modelo.Excepciones.ErrorFatal;
import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcMovimientoIlegitimo;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;

public class Partida {
	//LOGICA DE LA PARTIDA (turnos,...)
	//
	Jugador jugador1;
	Jugador jugador2;
	Tablero tablero;
	Map<String, Integer> movsRestantes= new HashMap<String, Integer>();
	Map<String, Boolean> yaAtaco= new HashMap<String, Boolean>();
	Map<String, Jugador> adversarios= new HashMap<String, Jugador>();
	
	public Partida (Tablero tab, Jugador primerJugador, Jugador segundoJugador){
		tablero = tab;
		jugador1 = primerJugador;
		jugador2 = segundoJugador;
		adversarios.put(jugador1.nombre(),jugador2);
		adversarios.put(jugador2.nombre(),jugador1);
		try {
			turnoTerminado();
		} catch (ExcHayGanador e) {
			throw new ErrorFatal();
		}
	}

	public void realizarAtaque(Jugador jugador, Personaje personaje, Posicion posicion, boolean esEspecial) throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero{
		Personaje destinatario; 
		if(!ataqueLegitimo(jugador, personaje, posicion)) throw new ExcAtaqueIlegitimo();
		
		try {
			destinatario = tablero.obtenerCasillero(posicion).obtenerPersonaje();
		} catch (ExcCasilleroDesocupado e) {
			throw new ExcAtaqueIlegitimo();
		}
		
		try {
			personaje.atacar(destinatario, esEspecial);
		} catch (ExcFueraDeRango | ExcAtaqueImposible e) {
			throw e;
		}
	}
	
	public void realizarMovimiento(Jugador jugador, Personaje personaje, Direccion direccion) throws ExcMovimientoIlegitimo, ExcPosicionOcupada, ExcFueraDeTablero{
		if(!movimientoLegitimo(jugador, personaje, direccion)) throw new ExcMovimientoIlegitimo();
		try {
			personaje.mover(direccion);
		} catch (ExcPosicionOcupada | ExcFueraDeTablero e) {
			throw e;
		}
	}
	
	public void turnoTerminado() throws ExcHayGanador{
		if(hayGanador()) throw new ExcHayGanador(ganador());
		jugador1.equipo.forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador1.equipo.forEach((k,v)->yaAtaco.put(k,false));
		jugador1.equipo.forEach((k,v)->v.sumarKi(5));
		
		jugador2.equipo.forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador2.equipo.forEach((k,v)->yaAtaco.put(k,false));
		jugador2.equipo.forEach((k,v)->v.sumarKi(5));
	}
	
	
	public void iterarEquipoAliado(Personaje personaje, )
	private Jugador ganador(){
		return jugador1;
		//Devuelve al ganador
	}
	
	private boolean personajePerteneceAJugador(Jugador jugador, Personaje personaje){
		return jugador.equipo().personajePertenece(personaje);
	}
	
	private boolean hayGanador(){
		return false;
		//Iterar equipos y ver si hay alguno con todos muertos
	}
	
	private boolean movimientoLegitimo(Jugador jugador, Personaje personaje, Direccion dir){
		if(!personajePerteneceAJugador(jugador,personaje)) return false;
		if(movsRestantes.get(personaje.nombre())==0) return false;
		return true;
	}
	
	private boolean ataqueLegitimo(Jugador jugador, Personaje personaje, Posicion posicion){
		if(!personajePerteneceAJugador(jugador,personaje)) return false;
		Personaje destinatario;
		try {
				destinatario=tablero.obtenerCasillero(posicion).obtenerPersonaje();
		} catch (ExcCasilleroDesocupado | ExcFueraDeTablero e) {
			return false;
		}
		if(!adversario(jugador).equipo().personajePertenece(destinatario)) return false;
		return yaAtaco.get(personaje.nombre());
	}
	
	private Jugador adversario(Jugador jugador){
		return adversarios.get(jugador.nombre);
	}

	public Equipo obtenerEquipoAliado(Personaje personaje) {
		
		Equipo equipo1 = jugador1.equipo();		
		Equipo equipo2 = jugador2.equipo();
		
		if(equipo1.personajePertenece(personaje)){
			return equipo1;
		}
		return equipo2;
		
	}
	

	
}

