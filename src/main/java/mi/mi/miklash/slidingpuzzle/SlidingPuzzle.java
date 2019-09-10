package mi.mi.miklash.slidingpuzzle;

import javafx.application.Application;
import javafx.stage.Stage;
import mi.mi.miklash.slidingpuzzle.initializer.GameInitializer;

public class SlidingPuzzle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GameInitializer.initGamePage(primaryStage);

    }
}
