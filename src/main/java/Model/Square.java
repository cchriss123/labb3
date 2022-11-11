package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static Model.ShapeType.SQUARE;

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

        if ((x > getX() - distanceCenterToSide) && (x < getX() + distanceCenterToSide))
            return (y > getY() - distanceCenterToSide) && y < (getY() + distanceCenterToSide);
        return false;
    }

    @Override
    public String writeSVG() {

        double distanceCenterToSide = (getSize()/2);

        String convertColor = getColor().toString().substring(2, 10);
        return "<rect x=\"" + (getX() - distanceCenterToSide) + "\" " +
                "y=\"" + (getY() - distanceCenterToSide) + "\" " +
                "width=\"" + getSize() + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"#" + convertColor + "\" />";
    }

    @Override
    public Shape getCopy() {
        return new Square(getColor(), getSize(), getX(), getY());
    }

    @Override
    public ShapeType getShapeType() {
        return SQUARE;
    }



}










