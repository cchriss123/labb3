package com.paintcnlabb.labb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PaintApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaintApplication.class.getResource("paint-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Paint!");
        stage.setScene(scene);
        stage.show();
        PaintController paintController = fxmlLoader.getController();
        paintController.setStage(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}