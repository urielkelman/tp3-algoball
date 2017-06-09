package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class RayoMortal extends Ataque {
	
	public RayoMortal (){
		costo = 20;
		modificadorDaņo = 150;
	}
	

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int daņoRealizado) {
	}
	
}
