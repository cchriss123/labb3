package com.paintcnlabb.labb3;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class PaintController {

    paintModel paintModel = new paintModel();


    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField size;
    public Stage stage;

    public void initialize(){

        context = canvas.getGraphicsContext2D();
        size.textProperty().bindBidirectional(paintModel.textProperty());
        colorPicker.valueProperty().bindBidirectional(paintModel.colorProperty());




    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        //System.out.println(paintModel.shapes.get(0).isInsideArea(mouseEvent.getX(), mouseEvent.getY()));

        paintModel.addCircle(mouseEvent.getX(), mouseEvent.getY());
        paintModel.addSquare(mouseEvent.getX(), mouseEvent.getY());

        updateCanvas();



    }

    private void updateCanvas() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (var shape : paintModel.shapes) {
            shape.draw(context);
        }
    }

    public void onUndoAction(ActionEvent event) {

        paintModel.undoShape();
        updateCanvas();
    }



    public void save(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV","*.csv"));

        File filePath = fileChooser.showSaveDialog(stage);

        if(filePath != null)
            paintModel.saveToFile(filePath.toPath());

    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void open(ActionEvent event) {
        //TODO
    }
}

