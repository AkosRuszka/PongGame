package sample;

import org.apache.log4j.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.apache.log4j.PropertyConfigurator;

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

    double starttime;
    double endtime;

    // for debug
    static Logger log = Logger.getLogger(Controller.class.getName());

    private void setPaneElements() {
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

        exitButton.setOnAction(event -> System.exit(0));

        Rectangle player1wall = new Rectangle(10,50);
        Rectangle player2wall = new Rectangle(10,50);
        player1wall.setX(10);
        player2wall.setX(680);


        gameBattlePane.setOnKeyPressed(event-> {
            switch (event.getCode()) {
                case W:
                    player1wall.setY(player1wall.getY()-10 < 10 ? 0 : player1wall.getY()-10);
                    break;
                case S:
                    player1wall.setY(player1wall.getY()+10 > 350 ? 350 : player1wall.getY()+10);
                    break;
                case UP:
                    player2wall.setY(player2wall.getY()-10 < 10 ? 0 : player2wall.getY()-10);
                    break;
                case DOWN:
                    player2wall.setY(player2wall.getY()+10 > 350 ? 350 : player2wall.getY()+10);
                    break;
                case ESCAPE: showMenuPane();
                    break;
            }
        });


        gameBattlePane.getChildren().addAll(player1wall,player2wall);
    }

    public void showMenuPane() {
        gamePane.setVisible(false);
        gamePane.setDisable(true);
        gameBattlePane.setFocusTraversable(false);
        menuPane.setDisable(false);
        menuPane.setVisible(true);

    }

    public void showGamePane() {
        menuPane.setDisable(true);
        menuPane.setVisible(false);
        gamePane.setDisable(false);
        gamePane.setVisible(true);
        gameBattlePane.setFocusTraversable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PropertyConfigurator.configure("log4j.properties");

        setPaneElements();
    }
}
