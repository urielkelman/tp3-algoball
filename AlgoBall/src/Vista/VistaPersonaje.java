package Vista;

import Modelo.Partida;
import Modelo.Personajes.Personaje;
import Vista.eventos.PersonajePresionadoMouseEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class VistaPersonaje extends HBox{
	public VistaPersonaje(Juego juego, Personaje personaje, Partida partida){
		this.setMaxSize(juego.pixelesAncho(), juego.pixelesAlto());
		this.getStyleClass().add("personaje");
		String imagen = getClass().getResource("img/personajes/"+personaje.nombre()+".png").toExternalForm();
		this.setStyle("-fx-background-image: url('" + imagen + "'); ");
		if(partida.esTurnoDelJugador().equipo().personajePertenece(personaje)){
			this.getStyleClass().add("coloreado");
			this.setOnMouseClicked(new PersonajePresionadoMouseEvent(personaje,juego.vistaLateral()));
		}
		
	}
	
	public void remarcar(){
		this.getStyleClass().add("remarcado");
	}
}