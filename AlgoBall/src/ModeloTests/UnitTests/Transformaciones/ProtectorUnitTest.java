package ModeloTests.UnitTests.Transformaciones;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Tablero;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Protector;

public class ProtectorUnitTest {
	Tablero tablero = new Tablero(5, 5);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba("Gohan", 300, 3, 3, 1);
	
	Protector transformacionProtector = new Protector();
	
	Equipo equipo1 = new Equipo("Equipo 1");
	
	
	@Test
	public void noEsPosibleTransformarProtector (){
		equipo1.agregarPersonaje(personaje1);
		equipo1.agregarPersonaje(personaje2);
		Assert.assertEquals(transformacionProtector.esPosible(personaje1, equipo1) , false);	
	}
	
	@Test
	public void esPosibleTransformarProtector () throws ExcNumeroNegativo{
		equipo1.agregarPersonaje(personaje1);
		equipo1.agregarPersonaje(personaje2);
		personaje2.recibirDanio(241);
		Assert.assertEquals(transformacionProtector.esPosible(personaje1, equipo1), true);
	}
	
}
