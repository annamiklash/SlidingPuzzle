package mi.mi.miklash.slidingpuzzle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPageController {

    @FXML
    private ImageView spider;
    @FXML
    private ImageView rubens;
    @FXML
    private ImageView space;

    @FXML
    private TextField nameTextField;


    @FXML
    public void onSpaceClick(MouseEvent mouseEvent) {
        space.setEffect(new DropShadow(50, Color.BLACK));


    }

    @FXML
    public void onRubensClick(MouseEvent mouseEvent) {
        rubens.setEffect(new DropShadow(50, Color.BLACK));

    }

    @FXML
    public void onSpiderClick(MouseEvent mouseEvent) {
        spider.setEffect(new DropShadow(50, Color.BLACK));


    }

    @FXML
    public void onStartGameButtonClick(ActionEvent actionEvent) throws IOException {
        if (nameTextField.getText().equals("") || nameTextField.getText().equals("ENTER YOUR NAME")) {

            nameTextField.setText("ENTER YOUR NAME");
            nameTextField.setOnMousePressed(event1 -> nameTextField.setText(""));
        } else {
            startGame(actionEvent);
        }
    }

    @FXML
    public void onShowResultsButtonClick(ActionEvent actionEvent) {

    }

    private void startGame (ActionEvent actionEvent) throws IOException {
        final Scene scene = ((Node) actionEvent.getSource()).getScene();
        final GridPane actualGamePage = (GridPane) scene.getRoot();
        final Stage stage = (Stage) scene.getWindow();


//        Init.initGamePage(stage, nameTextField.getText());

    }
}
