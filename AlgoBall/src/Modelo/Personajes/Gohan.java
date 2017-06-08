package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Gohan extends Personaje {

	public Gohan(Tablero mundo){
			
		nombre = "Gohan";
		puntosDeVida = 300;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = null;
		tablero = mundo;
		inicializar();
		
		TransformacionPorKi superSaiyan1 = new TransformacionPorKi("Super Saiyan 1", 10, 2,2,30 );
		
		transformaciones.add(superSaiyan1);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
