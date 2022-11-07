package com.paintcnlabb.labb3;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static com.paintcnlabb.labb3.ShapeType.TRIANGLE;
import static org.junit.jupiter.api.Assertions.*;

class PaintModelTest {

    PaintModel paintModel = new PaintModel();

    @Test
    void createShapeCreatesCorrectShapeType() {
        paintModel.createShape(TRIANGLE, 100, 100);
        var expected = TRIANGLE;
        var actual = paintModel.shapes.size();

        assertEquals(expected, TRIANGLE);
    }

    @Test
    void testingIfShapesIsCorrectSizeAfterUndo(){

        paintModel.undoStack.add(new ArrayDeque<>(paintModel.getCopyOfShapes()));
        paintModel.redoStack.clear();
        paintModel.createShape(TRIANGLE, 100, 100);

        paintModel.undoStack.add(new ArrayDeque<>(paintModel.getCopyOfShapes()));
        paintModel.redoStack.clear();
        paintModel.createShape(TRIANGLE, 100, 100);

        paintModel.undoShape();

        var expected = 1;
        var actual = paintModel.shapes.size();

        assertEquals(expected,actual);

    }
}

