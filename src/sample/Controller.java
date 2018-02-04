package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    //<editor-fold desc="FXML annotations">
    @FXML
    Pane gamePane;
    @FXML
    Pane menuPane;
    @FXML
    Pane gameBattlePane;
    @FXML
    Button newGameButton;
    @FXML
    Button gameContinueButton;
    @FXML
    Button helpButton;
    @FXML
    Button exitButton;
    @FXML
    Button settingsButton;
    //</editor-fold>

    private void setMenuPane() {
        newGameButton.setOnAction(event -> {
            showGamePane();
            /* new Game object */
        });
        gameContinueButton.setOnAction(event -> {
            /* initialized Game object load */
        });
        helpButton.setOnAction(event -> {
            /* show help text in new Pane or popup window */
        });
        exitButton.setOnAction(event -> {
            System.exit(0);
        });
    }

    public void showGamePane() {
        menuPane.setDisable(true);
        menuPane.setVisible(false);
        gamePane.setVisible(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMenuPane();
    }
}
