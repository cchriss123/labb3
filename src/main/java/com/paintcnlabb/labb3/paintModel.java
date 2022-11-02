package com.paintcnlabb.labb3;



import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class paintModel {

    ObjectProperty<Color> color;
    DoubleProperty size;


    ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);
    ObservableList<Shape> shapes = FXCollections.observableArrayList();
    ArrayList<Shape> undoList = new ArrayList();


    public paintModel() {
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleDoubleProperty(50.0);

    }

    public void createShape(ShapeType type,double x, double y){
        switch (type) {
            case CIRCLE -> shapes.add(new Circle(getColor(), getSize(), x, y));
            case SQUARE -> shapes.add(new Square(getColor(), getSize(), x, y));
        };
    }

    public void undoShape() {

        undoList.add(shapes.get(shapes.size()-1));
        shapes.remove(shapes.size()-1);


    }



    public void saveToFile(Path file) {
        StringBuffer outPut = new StringBuffer();
        for (int i = 0; i < shapes.size() - 1; i++) {
            outPut.append(shapes.get(i).getColor());
            outPut.append(",");
            outPut.append(shapes.get(i).getSize());
            outPut.append(",");
            outPut.append(shapes.get(i).getX());
            outPut.append(",");
            outPut.append(shapes.get(i).getY());
        }
        try {
            Files.writeString(file, outPut.toString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Property<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public double getSize() {
        return size.get();
    }

    public DoubleProperty sizeProperty() {
        return size;
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public Property<ShapeType> currentShapeTypeProperty() {
        return currentShapeType;
    }

    public void loadFile(File selectedFile) {
        //TODO


    }

    public void redoShape() {

        shapes.add(undoList.get(undoList.size()-1));
        undoList.remove(undoList.get(undoList.size()-1));






    }
}

