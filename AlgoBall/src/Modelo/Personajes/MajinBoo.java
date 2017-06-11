package Modelo.Personajes;

import Modelo.Partida;
import Modelo.Ataques.ConvierteteEnChocolate;
import Modelo.Transformaciones.TransformacionPorKi;

public class MajinBoo extends Personaje {
	public MajinBoo(Partida p){
		
		nombre = "Majin Boo";
		puntosDeVida = 300;
		poderDePelea = 30;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = new ConvierteteEnChocolate(p);
		partida = p;
		inicializar();
		
		TransformacionPorKi booMalo = new TransformacionPorKi("Boo Malo", 20, 2,3,50);
		TransformacionPorKi booOriginal = new TransformacionPorKi("Boo Original", 50,3,4,60);
		
		
		transformaciones.add(booMalo);
		transformaciones.add(booOriginal);
		
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
