package com.paintcnlabb.labb3;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PaintController {

    paintModel paintModel = new paintModel();

    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField brushSize;
    public Stage stage;

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        double size = Double.parseDouble(brushSize.getText());
        //paintModel.addCircle(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY());
        //paintModel.addSquare(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY());

        paintModel.shapes.add(new Circle(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY()));
        paintModel.shapes.add(new Square(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY()));

        updateCanvas();
    }

    private void updateCanvas() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (var shape : paintModel.shapes) {
            shape.draw(context);
        }
    }

    public void onUndoAction(ActionEvent event) {
        paintModel.shapes.remove(paintModel.shapes.size()-1);
        //paintModel.undoShape();
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
        // TODO
    }
}

