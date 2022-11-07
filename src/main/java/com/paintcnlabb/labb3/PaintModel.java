package com.paintcnlabb.labb3;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import java.util.ArrayDeque;
import java.util.Deque;

public class PaintModel {

    ObjectProperty<Color> color;
    DoubleProperty size;

    ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.TRIANGLE);
    ObservableList<Shape> shapes = FXCollections.observableArrayList();
    ArrayDeque<ArrayDeque<Shape>> undoStack;
    ArrayDeque<ArrayDeque<Shape>> redoStack;

    public PaintModel() {
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleDoubleProperty(50.0);
        this.undoStack = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
    }

    public void createShape(ShapeType type,double x, double y){
        switch (type) {
            case CIRCLE -> shapes.add(new Circle(getColor(), getSize(), x, y));
            case SQUARE -> shapes.add(new Square(getColor(), getSize(), x, y));
            case TRIANGLE -> shapes.add(new Triangle(getColor(), getSize(), x, y));
        }
    }

    public ArrayDeque<Shape> getCopyOfShapes() {
        ArrayDeque<Shape> copyOfShapes = new ArrayDeque<>();
        shapes.forEach(shape -> copyOfShapes.add(shape.getCopy()));
        return copyOfShapes;
    }

    public void undoShape() {

        if(!undoStack.isEmpty()) {
            redoStack.add(getCopyOfShapes());
            shapes.clear();
            shapes.addAll(undoStack.removeLast());
        }
    }

    public void redoShape() {

        if(!redoStack.isEmpty()){
            undoStack.addLast(getCopyOfShapes());
            shapes.clear();
            shapes.addAll(redoStack.removeLast());
        }
    }

    public Property<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public double getSize() {
        return size.get();
    }

    public DoubleProperty sizeProperty() {
        return size;
    }

    public Property<ShapeType> currentShapeTypeProperty() {
        return currentShapeType;
    }
}

