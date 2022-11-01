package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x, y);
    }

    double distanceCenterToSide = (getSize()/2);

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.getColor());
        context.fillRect(getX() - distanceCenterToSide, getY() - distanceCenterToSide, getSize(), getSize());

    }

    @Override
    public boolean isInsideArea(double x, double y) {

        double distanceX = Math.abs(x - getX());
        double distanceY = Math.abs(y - getY());

        /*
        distanceX = x - getX();
        if (distanceX <0)
            distanceX = distanceX*-1;

         */

        return (distanceX < distanceCenterToSide) && (distanceY < distanceCenterToSide);





/*
        if ((x > getX() - distanceCenterToSide) && (x < getX() + distanceCenterToSide))
            return (y > getY() - distanceCenterToSide) && y < (getY() + distanceCenterToSide);
        return false;


 */

    }

}










