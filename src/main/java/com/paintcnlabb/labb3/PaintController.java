package com.paintcnlabb.labb3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PaintController {

    public Canvas canvas;
    public GraphicsContext context;

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        //context.setFill(Color.yellow);
        //context.fillRect(0,0,400,400);
        context.setFill(Color.BLUE);
        context.fillRect(mouseEvent.getX()-(2.5), mouseEvent.getY()-(2.5), 5,5);



    }
}