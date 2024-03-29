package mi.mi.miklash.slidingpuzzle.listener;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import lombok.AllArgsConstructor;
import mi.mi.miklash.slidingpuzzle.controller.GameController;
import mi.mi.miklash.slidingpuzzle.model.Node;

@AllArgsConstructor
public class MouseExitedListener implements EventHandler<MouseEvent> {


    private final GameController gameController;
    private final Node node;

    @Override
    public void handle(MouseEvent event) {
        node.setEffect(null);

    }
}
