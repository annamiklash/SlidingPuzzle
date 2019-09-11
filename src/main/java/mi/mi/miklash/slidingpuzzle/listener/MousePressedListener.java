package mi.mi.miklash.slidingpuzzle.listener;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import lombok.AllArgsConstructor;
import mi.mi.miklash.slidingpuzzle.controller.GameController;
import mi.mi.miklash.slidingpuzzle.model.Node;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


@AllArgsConstructor
public class MousePressedListener implements EventHandler<MouseEvent> {

    private final GameController gameController;
    private final Node node;

    @Override
    public void handle(MouseEvent event) {
        System.out.println("node " + node.getNodeNumber() + " is selected");
        try {
            gameController.handleSelection(node);

        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }

    }


}
