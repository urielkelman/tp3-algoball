package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Piccolo;
	
	public class test03 {
		
		Tablero tablero = new Tablero(15, 15);
		Equipo GuerrerosZ = new Equipo("GuerrerosZ");
		Piccolo piccolo = new Piccolo(tablero);
		Gohan gohan = new Gohan(tablero);
		
		@Test
		public void PiccoloSeTransformaCorrectamente() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo, ExcNoEsPosibleTransformarse{
			GuerrerosZ.agregarPersonaje(piccolo);
			GuerrerosZ.agregarPersonaje(gohan);
			
			tablero.posicionarPersonaje(gohan, new Posicion(1, 1));
			tablero.posicionarPersonaje(piccolo, new Posicion(5,5));
			
			Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
			Freezer freezer = new Freezer(tablero);
			EnemigosDeLaTierra.agregarPersonaje(freezer);
			
			tablero.posicionarPersonaje(freezer, new Posicion(5,6));
			
			int vidaInicial = freezer.puntosDeVida();
			piccolo.atacar(freezer, false);
			
			int vidaTrasAtaqueSinTransformacion = freezer.puntosDeVida();
			int dañoRealizadoConAtaqueSinTransformacion = vidaInicial - vidaTrasAtaqueSinTransformacion;
			
			piccolo.seAvanzoUnTurno(20);
			
			piccolo.transformar(GuerrerosZ);
			
			piccolo.atacar(freezer, false);
			
			int vidaTrasAtaqueConTrasformacion = freezer.puntosDeVida();
			int dañoRealizadoConAtaqueConTransformacion = vidaTrasAtaqueSinTransformacion - vidaTrasAtaqueConTrasformacion;
			
			Assert.assertTrue("El ataque habiendose trasnformado saca mas", (dañoRealizadoConAtaqueConTransformacion > dañoRealizadoConAtaqueSinTransformacion));
		}
		
		@Test (expected = ExcNoEsPosibleTransformarse.class)
		public void PiccoloNoPuedeLlegarALaSegundaTransformacionYaQueSeAtacoAGohan() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate{			
			GuerrerosZ.agregarPersonaje(piccolo);
			GuerrerosZ.agregarPersonaje(gohan);
			
			tablero.posicionarPersonaje(gohan, new Posicion(1, 1));
			tablero.posicionarPersonaje(piccolo, new Posicion(5,5));
			
			piccolo.seAvanzoUnTurno(20);
			piccolo.transformar(GuerrerosZ);
			
			piccolo.seAvanzoUnTurno(20);
			piccolo.transformar(GuerrerosZ);
			
			
			
			
			
		}
		
		
}
