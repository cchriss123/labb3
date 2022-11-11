package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.paintcnlabb.labb3.ShapeType.TRIANGLE;


public class Triangle extends Shape {

    double[] xCoords = new double[3];
    double[] yCoords = new double[3];

    public Triangle(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x, y);
    }

    @Override
    public void draw(GraphicsContext context) {

        double sizeSquarded = getSize() * getSize();
        double halfSizeSquared = (getSize()/2)*(getSize()/2);
        double hight = Math.sqrt(sizeSquarded-halfSizeSquared);
        
        xCoords[0] = getX();
        yCoords[0] = Math.round(getY()-hight*0.67);
        xCoords[1] = Math.round(getX()+(getSize()/2));
        yCoords[1] = Math.round(getY()+hight*0.33);
        xCoords[2] = Math.round(getX()-(getSize()/2));
        yCoords[2] = Math.round(getY()+hight*0.33);

        context.setFill(getColor());
        context.fillPolygon(xCoords,yCoords,3);
    }
    
    @Override
    public boolean isInsideArea(double x, double y) {

        // study barycentric coordinates for explanation
        double distanceX = x - xCoords[2];
        double distanceY = y - yCoords[2];
        double distanceX21 = xCoords[2]-xCoords[1];
        double distanceY12 = yCoords[1]-yCoords[2];
        double D = distanceY12*(xCoords[0]-xCoords[2]) + distanceX21*(yCoords[0]-yCoords[2]);
        double s = distanceY12*distanceX + distanceX21*distanceY;
        double t = ((yCoords[2] - yCoords[0]) * distanceX) + ((xCoords[0] - xCoords[2]) * distanceY);

        if (D<0)
            return s<=0 && t<=0 && s+t>=D;
        return s>=0 && t>=0 && s+t<=D;
    }

    @Override
    public String writeSVG() {

        double sizeSquarded = getSize() * getSize();
        double halfSizeSquared = (getSize()/2)*(getSize()/2);
        double hight = Math.sqrt(sizeSquarded-halfSizeSquared);

        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<polygon " +
                "points=" +
                "\"" +
                (getX())               + "," + Math.round(getY()-hight*0.67) + " " +
                (getX()+(getSize()/2)) + "," + Math.round(getY()+hight*0.33) + " " +
                (getX()-(getSize()/2)) + "," + Math.round(getY()+hight*0.33) +
                "\" " + "fill=\"" + convertColor + "\" />";
    }

    @Override
    public Shape getCopy() {
        return new Triangle(getColor(), getSize(), getX(), getY());
    }
    @Override
    public ShapeType getShapeType() {
        return TRIANGLE;
    }
}
