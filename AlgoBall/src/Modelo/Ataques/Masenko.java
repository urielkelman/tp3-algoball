package Modelo.Ataques;

import Modelo.Personajes.Personaje;

public class Masenko extends Ataque {
	
	public Masenko (){
		costo = 10;
		modificadorDaņo = 125;
	}

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int daņoRealizado) {
	}
	
}
