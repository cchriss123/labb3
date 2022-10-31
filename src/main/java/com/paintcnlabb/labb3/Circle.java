package com.paintcnlabb.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    double radius = (getSize()/2);

    public Circle(Color currentColor, double size, double x, double y) {
        super(currentColor, size, x ,y);
    }


    @Override
    public void draw(GraphicsContext context){
        context.setFill(this.getColor());
        context.fillOval(getX()-radius,getY()-radius, getSize(),getSize());



    }

    @Override
    public boolean isInsideArea(double x, double y) {


        //In general, x and y must satisfy (x - center_x)² + (y - center_y)² < radius².
        double distanceXSquare = (x - getX())*(x - getX());
        double distanceYSquare = (y - getY())*(y - getY());
        double radiusSquare = radius * radius;

        return (distanceXSquare+distanceYSquare) < radiusSquare;
        }








}
