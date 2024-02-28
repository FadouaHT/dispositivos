package com.example.dispositivosfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * This class represents an inventory of devices.
 * It has attributes like a list of devices, sorting order, and the path for printing the list of devices.
 */
public class HelloApplication extends Application {
    /**
     * This method is called when the application is launched.
     * It sets up the main stage and scene, and shows the stage.
     * @param stage The main stage for the application.
     * @throws IOException If there is an error loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This is the main method of the application.
     * It calls the launch method to start the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}