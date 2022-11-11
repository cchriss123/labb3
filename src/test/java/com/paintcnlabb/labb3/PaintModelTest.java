package com.paintcnlabb.labb3;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;

import static com.paintcnlabb.labb3.ShapeType.TRIANGLE;
import static org.junit.jupiter.api.Assertions.*;

class PaintModelTest {

    PaintModel paintModel = new PaintModel();

    @Test
    void createShapeCreatesCorrectShapeType() {
        paintModel.createShape(TRIANGLE, 100, 100);
        var actual = paintModel.shapes.get(0).getShapeType();

        assertEquals(actual, TRIANGLE);
    }

    @Test
    void testingIfShapesIsCorrectSizeAfterUndo(){

        paintModel.createShape(TRIANGLE, 100, 100);
        paintModel.createShape(TRIANGLE, 100, 100);

        paintModel.undoShape();

        var expected = 1;
        var actual = paintModel.shapes.size();

        assertEquals(expected,actual);

    }
}

