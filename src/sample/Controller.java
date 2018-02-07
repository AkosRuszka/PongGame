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

    // for debug
    static Logger log = Logger.getLogger(Controller.class.getName());

    Player playerOne;
    Player playerTwo;
    Thread playerOneThread;
    Thread playerTwoThread;

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

        playerOne = new Player(1,player1wall);
        playerTwo = new Player(2,player2wall);

        playerOneThread = new Thread(playerOne);
        playerTwoThread = new Thread(playerTwo);

        playerOneThread.start();
        playerTwoThread.start();

        gameBattlePane.setOnKeyPressed(event-> {
            switch (event.getCode()) {
                case W:
                    playerOne.up(true);
                    break;
                case S:
                    playerOne.down(true);
                    break;
                case UP:
                    playerTwo.up(true);
                    break;
                case DOWN:
                    playerTwo.down(true);
                    break;
                case ESCAPE:
                    showMenuPane();
                    break;
            }
        });

        gameBattlePane.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                    playerOne.up(false);
                    break;
                case S:
                    playerOne.down(false);
                    break;
                case UP:
                    playerTwo.up(false);
                    break;
                case DOWN:
                    playerTwo.down(false);
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
        gameBattlePane.focusedProperty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //PropertyConfigurator.configure("log4j.properties");
        setPaneElements();
    }
}
