package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x, y);
    }


    @Override
    public void draw(GraphicsContext context) {

        double sizeSquarded = getSize() * getSize();
        double halfSizeSquared = (getSize()/2)*(getSize()/2);
        double hight = Math.sqrt(sizeSquarded-halfSizeSquared);

        double[] xCoords = new double[3];
        double[] yCoords = new double[3];
        xCoords[0] = getX();
        yCoords[0] = getY()-(hight*0.67);
        xCoords[1] = getX()+(getSize()/2);
        yCoords[1] = getY()+(hight*0.33);
        xCoords[2] = getX()-(getSize()/2);
        yCoords[2] = getY()+(hight*0.33);
        

        context.setFill(getColor());
        context.fillPolygon(xCoords,yCoords,3);



    }

    @Override
    public boolean isInsideArea(double x, double y) {
        return false;
    }
}
