package ModeloTests.UnitTests.Transformaciones;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Tablero;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Transformacion;
import Modelo.Transformaciones.TransformacionPorKi;

public class TransformacionPorKiUnitTests {
	
	Tablero tablero = new Tablero(5, 5);
	Equipo equipo = new Equipo("equipo1");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 3, 3, 1);
	Transformacion trans = new TransformacionPorKi("Prueba", 10, 20, 30, 40);
	
	@Test
	public void transformacionNoEsPosible(){
		Equipo equipo = new Equipo("Equipo");
		equipo.agregarPersonaje(personaje1);
		Assert.assertFalse(trans.esPosible(personaje1, equipo));
	}
	
	@Test
	public void transformacionEsPosible() throws ExcNumeroNegativo{
		Equipo equipo = new Equipo("Equipo");
		personaje1.seAvanzoUnTurno(10);
		equipo.agregarPersonaje(personaje1);
		Assert.assertTrue(trans.esPosible(personaje1, equipo));
	}
}
