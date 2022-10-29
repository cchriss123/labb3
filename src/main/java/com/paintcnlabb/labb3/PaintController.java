package com.paintcnlabb.labb3;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PaintController {

    paintModel paintModel = new paintModel();

    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField brushSize;

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        double size = Double.parseDouble(brushSize.getText());
        //paintModel.addShape(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY());
        paintModel.shapes.add(new Shape(colorPicker.getValue(), size, mouseEvent.getX(), mouseEvent.getY()));
        update();
    }

    private void update() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (var shape : paintModel.shapes) {
            shape.draw(context);
        }
    }

    public void save(ActionEvent actionEvent) {
        //TODO
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onUndoAction(ActionEvent event) {
        paintModel.undoShape();
        update();
    }

}

