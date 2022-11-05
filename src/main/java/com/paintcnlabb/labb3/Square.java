package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x, y);
    }



    @Override
    public void draw(GraphicsContext context) {

        double distanceCenterToSide = (getSize()/2);

        context.setFill(this.getColor());
        context.fillRect(getX() - distanceCenterToSide, getY() - distanceCenterToSide, getSize(), getSize());

    }

    @Override
    public boolean isInsideArea(double x, double y) {

        double distanceCenterToSide = (getSize()/2);

        //double distanceX = Math.abs(x - getX());
        //double distanceY = Math.abs(y - getY());
        //return (distanceX < distanceCenterToSide) && (distanceY < distanceCenterToSide);

        double distanceX = (x - getX());
        double distanceY = (y - getY());
        if(distanceX > 0 && distanceY > 0)
            return (distanceX < distanceCenterToSide) && (distanceY < distanceCenterToSide);
        return false;
        //TODO FIND THE BUG!

/*
        if ((x > getX() - distanceCenterToSide) && (x < getX() + distanceCenterToSide))
            return (y > getY() - distanceCenterToSide) && y < (getY() + distanceCenterToSide);
        return false;


 */

    }

    @Override
    public String writeSVG() {
        String convertColor = getColor().toString().substring(2, 10);
        return "<rect x=\"" + (getX() - getSize()/2) + "\" " +
                "y=\"" + (getY() - getSize()/2) + "\" " +
                "width=\"" + getSize() + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"#" + convertColor + "\" />";
    }


}










