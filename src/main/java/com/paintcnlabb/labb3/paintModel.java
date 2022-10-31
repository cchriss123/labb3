package com.paintcnlabb.labb3;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class paintModel {

    ObjectProperty<Color> color;
    StringProperty size;
    ObservableList<Shape> shapes = FXCollections.observableArrayList();




    public paintModel() {
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleStringProperty("100");
    }

    void addCircle(double x, double y) {
        shapes.add(new Circle(getColor(), getSize(), x, y));
    }

    void addSquare(double x, double y) {
        shapes.add(new Square(getColor(), getSize(), x, y));
    }


    public void undoShape() {
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

    public Property<String> textProperty() {
        return size;
    }


    public Color getColor() {
        return color.get();
    }

    public Double getSize() {
        return Double.parseDouble(size.get());

    }




}

