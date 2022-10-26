package com.paintcnlabb.labb3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PaintController {

    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField brushSize;

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    public void onCanvasDragged(MouseEvent mouseEvent) {

        double size = Double.parseDouble(brushSize.getText());

        context.setFill(colorPicker.getValue());
        //context.fillRect(mouseEvent.getX()-(size/2), mouseEvent.getY()-(size/2),size,size);
        context.fillRoundRect(mouseEvent.getX()-(size/2), mouseEvent.getY()- (size/2), size,size,size,size);



    }

    public void save(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}