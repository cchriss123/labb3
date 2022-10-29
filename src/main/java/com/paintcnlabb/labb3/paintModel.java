package com.paintcnlabb.labb3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class paintModel {

    ObservableList<Shape> shapes = FXCollections.observableArrayList();


/*
    void addCircle(Color currentColor, double size, double x, double y) {
        shapes.add(new Circle(currentColor, size, x, y));
    }
    void addSquare(Color currentColor, double size, double x, double y) {
        shapes.add(new Square(currentColor, size, x, y));
    }

    public void undoShape() {
        shapes.remove(shapes.size()-1);
    }

 */

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
}

