package Vista.eventos;

import Vista.BarraDeMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AplicacionOnKeyPressedEvento implements EventHandler<KeyEvent> {

    private BarraDeMenu menuBar;

    public AplicacionOnKeyPressedEvento(BarraDeMenu menuBar) {
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            menuBar.aplicacionHabilitarMaximizar();
        }
    }
}