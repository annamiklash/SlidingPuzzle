package mi.mi.miklash.slidingpuzzle.initializer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mi.mi.miklash.slidingpuzzle.view.GameBoard;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class GameInitializer {

    public static void initStartPage(Stage stage) {
        try {
            final GridPane startPage = loadStartPage();

            stage.setScene(new Scene(startPage));
            stage.setResizable(false);

            stage.setTitle("Sliding Puzzle");

            stage.hide();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initGamePage(Stage stage) {
        final GameBoard gameBoard = new GameBoard();

        stage.setScene(new Scene(gameBoard.getGridPane()));

        stage.hide();
        stage.show();
    }


    private static GridPane loadStartPage() throws IOException {
        return FXMLLoader.load(requireNonNull(GameInitializer.class.getClassLoader().getResource("GUI/StartPage.fxml")));
    }
}
