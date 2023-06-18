import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;


import java.util.Arrays;
import java.util.List;

public class GoBoomGUI extends Application {
    private Game game;
    private Text gameStatusText;
    private List<Text> playerInfoTexts;
    private Button playButton;
    private Button resumeButton;
    private Button exitButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GoBoom Game");
    
        // Create player names
        List<String> playerNames = Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4");
    
        // Create game instance
        game = new Game(playerNames);
    
        // Create buttons
        playButton = createButtonWithName("Play");
        playButton.setOnAction(e -> showPlayer());
        resumeButton = createButtonWithName("Resume");
        resumeButton.setOnAction(e -> resumeGame());
        exitButton = createButtonWithName("Exit");
        exitButton.setOnAction(e -> exitGame());
    
        // Create a game status text
        gameStatusText = new Text();
    
        // Create a player info text for each player
        playerInfoTexts = new ArrayList<>();

        // Arrange the player info texts in a vertical layout
        VBox playerInfoContainer = new VBox(10);
        playerInfoContainer.getChildren().addAll(playerInfoTexts);
        playerInfoContainer.setAlignment(Pos.CENTER);
        playerInfoContainer.setPadding(new Insets(10));
    
        // Arrange buttons in a vertical layout
        VBox buttonContainer = new VBox(10, playButton, resumeButton, exitButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(10));
    
        // Create a game layout
        VBox gameLayout = new VBox(10, gameStatusText, playerInfoContainer, buttonContainer);
        gameLayout.setAlignment(Pos.CENTER);
        gameLayout.setPadding(new Insets(10));
    
        // Create a root layout
        BorderPane root = new BorderPane();
        root.setCenter(gameLayout);
    
        // Create a scene
        Scene scene = new Scene(root, 800, 600);
    
        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Button createButtonWithName(String name) {
        return new Button(name);
    }

    private void showPlayer() {
        // Display player names
        List<String> playerNames = Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4");
    
        for (String playerName : playerNames) {
            Text playerInfoText = new Text();
            playerInfoText.setText("Player " + playerName);
            playerInfoTexts.add(playerInfoText);
        }

        // Hide the buttons
        playButton.setVisible(false);
        resumeButton.setVisible(false);
        exitButton.setVisible(false);
    }
    
    private void resumeGame() {
        // Implement game resume logic
    }

    private void exitGame() {
        // Close the application
        System.exit(0);
    }
}
