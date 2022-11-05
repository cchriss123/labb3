package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Triangle extends Shape {

    double[] xcoords = new double[3];
    double[] ycoords = new double[3];

    public Triangle(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x, y);
    }

    @Override
    public void draw(GraphicsContext context) {

        double sizeSquarded = getSize() * getSize();
        double halfSizeSquared = (getSize()/2)*(getSize()/2);
        double hight = Math.sqrt(sizeSquarded-halfSizeSquared);


        xcoords[0] = getX();
        ycoords[0] = getY()-hight*0.67;
        xcoords[1] = getX()+(getSize()/2);
        ycoords[1] = getY()+hight*0.33;
        xcoords[2] = getX()-(getSize()/2);
        ycoords[2] = getY()+hight*0.33;

        context.setFill(getColor());
        context.fillPolygon(xcoords,ycoords,3);
    }


    @Override
    public boolean isInsideArea(double x, double y) {

        double distanceX = x - xcoords[2];
        double distanceY = y - ycoords[2];
        double distanceX21 = xcoords[2]-xcoords[1];
        double distanceY12 = ycoords[1]-ycoords[2];
        double D = distanceY12*(xcoords[0]-xcoords[2]) + distanceX21*(ycoords[0]-ycoords[2]);
        double s = distanceY12*distanceX + distanceX21*distanceY;
        double t = ((ycoords[2] - ycoords[0]) * distanceX) + ((xcoords[0] - xcoords[2]) * distanceY);

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
                (getX())               + "," + (getY()-hight*0.67) + " " +
                (getX()+(getSize()/2)) + "," + (getY()+hight*0.33) + " " +
                (getX()-(getSize()/2)) + "," + (getY()+hight*0.33) +
                "\" " + "fill=\"" + convertColor + "\" />";
    }
}
