package Modelo;

public class AtaqueNormal extends Ataque {
	int da�o;
	
	public AtaqueNormal(int puntosDa�o){
		da�o=puntosDa�o;
	}

	@Override
	protected int costo() {
		return 0;
	}

	@Override
	protected int da�o(Personaje destinatario) {
		return da�o;
	}

	@Override
	protected void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible {
		return;
	}

}