package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Personajes.PersonajeFactory;

public class test05 {
	
	Tablero tablero = new Tablero(15,14);
	Jugador primerJugador = new Jugador("nombre1", tablero);
	Jugador segundoJugador = new Jugador("nombre2", tablero);
	PersonajeFactory factory = new PersonajeFactory();	
	Personaje goku = factory.getPersonaje("goku");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba( "Personaje1", 300, 3, 3, 1);
	
	Equipo equipo = new Equipo("Guerreros de la Tierra");
	Equipo equipo_2 = new Equipo("Equipo 2");
	
	
	Partida partida = new Partida(tablero, primerJugador, segundoJugador);
	
	@Test
	public void Test05SePosicionaYTransformaCorrectamente() throws ExcNoEsPosibleTransformarse, ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcEsChocolate, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcCasilleroDesocupado{
		equipo.agregarPersonaje(goku);
		equipo_2.agregarPersonaje(personaje1);
		
		Posicion posicion =  new Posicion(10,10);
		tablero.posicionarPersonaje(goku, posicion);
		Assert.assertEquals(goku.posicion(), posicion);
		
		Posicion posicion_2 =  new Posicion(9,10);
		tablero.posicionarPersonaje(personaje1, posicion_2);
		
		goku.seAvanzoUnTurno(20);
		
		goku.transformar(equipo);
		Assert.assertEquals("Goku tiene el ki correcto", goku.ki() ,0);
		tablero.moverPersonaje(goku, new Posicion (13,10));
		Assert.assertEquals("Tiene la velocidad correcta", goku.posicion().posX(),13);
				
	}
}


