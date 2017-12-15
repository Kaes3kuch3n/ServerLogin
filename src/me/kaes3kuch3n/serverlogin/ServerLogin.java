package me.kaes3kuch3n.serverlogin;

import javafx.application.Application;
import javafx.stage.Stage;

public class ServerLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new LoginGui();
    }
}
