package Modelo.Ataques;

import Modelo.Personajes.Personaje;

public class Kamekameha extends Ataque {
	
	public Kamekameha() {
		costo = 20;
		modificadorDaņo = 150;
	}

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int daņoRealizado) {
	}
	
	
}
