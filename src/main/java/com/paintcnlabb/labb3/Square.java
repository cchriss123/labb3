package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x ,y);
    }

    @Override
    public void draw(GraphicsContext context){
        context.setFill(this.getColor());
        context.fillRect(getX()-(getSize()/2),getY()- (getSize()/2), getSize(),getSize());

    }
}
