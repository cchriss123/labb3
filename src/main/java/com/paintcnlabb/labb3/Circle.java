package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {


    public Circle(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x ,y);
    }


    @Override
    public void draw(GraphicsContext context){

        double radius = getSize()/2;

        context.setFill(this.getColor());
        context.fillOval(getX()-radius,getY()-radius, getSize(),getSize());
    }

    @Override
    public boolean isInsideArea(double x, double y) {

        //In general, x and y must satisfy (x - center_x)² + (y - center_y)² < radius².
        double radius = getSize()/2;

        double distanceXSquared = (x - getX())*(x - getX());
        double distanceYSquared = (y - getY())*(y - getY());
        double radiusSquared = radius * radius;

        return (distanceXSquared+distanceYSquared) < radiusSquared;
        }

    @Override
    public String writeSVG() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<circle " +
                "cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + getSize() / 2 + "\" " +
                "fill=\"" + convertColor + "\" />";
    }

    @Override
    public Shape getCopy() {
        return new Circle(getColor(), getSize(), getX(), getY());
    }
}
