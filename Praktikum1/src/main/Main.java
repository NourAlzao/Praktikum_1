package main;

import gui.StadtfuehrungControl;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        new StadtfuehrungControl(primaryStage); // Aktualisiert auf die neue Klasse
    }

    public static void main(String[] args) {
        launch(args);
    }
}


