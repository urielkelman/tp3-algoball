package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Makankosappo extends Ataque {
	
	public void Masenko (){
		costo = 10;
	}
	
	protected int daņoParcial() {
		return ((daņoBase*120)/100);
	
	}

	@Override
	protected void efectosColaterales(int daņoRealizado) {
	}

}
