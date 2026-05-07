package ua.org.olden.visualizingmathematics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App extends Application {

    protected static Scene scene;
    protected static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        Font.loadFont(App.class.getResourceAsStream("fonts/DejaVu Sans Mono.ttf"), 13);

        //scene = new Scene(loadFXML("primary"), 800, 600);
        scene = new Scene(loadFXML("primary"));

        stage.setOnCloseRequest(e -> quit());
        stage.setOnShown(e -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });

        stage.setScene(scene);

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void quit() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }

}
