package Modelo;

public abstract class Ataque {
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
			destinatario.recibirDa�o(this.da�o(destinatario));
		} catch(ExcAtaqueImposible e){
			throw e;
		}
	}
	
	protected abstract int costo();
	protected abstract int da�o(Personaje destinatario);
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
