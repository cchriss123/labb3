package com.paintcnlabb.labb3;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.io.File;


public class PaintController {

    paintModel paintModel = new paintModel();

    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());
    public ChoiceBox<ShapeType> choiceBox;
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField size;
    public Stage stage;


    public void initialize(){
        choiceBox.setItems(shapeTypesList);
        choiceBox.setValue(ShapeType.CIRCLE);

        context = canvas.getGraphicsContext2D();

        StringConverter converter = new DoubleStringConverter();
        Bindings.bindBidirectional(size.textProperty(),paintModel.sizeProperty() ,converter );
        colorPicker.valueProperty().bindBidirectional(paintModel.colorProperty());


        updateCanvas();


    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        switch (mouseEvent.getButton()) {
            case PRIMARY -> {
                paintModel.createShape(choiceBox.getValue(), mouseEvent.getX(), mouseEvent.getY());
                updateCanvas();
            }
            case SECONDARY -> {

               paintModel.shapes.stream()
                    .filter(shape -> shape.isInsideArea(mouseEvent.getX(), mouseEvent.getY()))
                    .findFirst().ifPresent(shape -> shape.setColor(colorPicker.getValue()));

                paintModel.shapes.stream()
                        .filter(shape -> shape.isInsideArea(mouseEvent.getX(), mouseEvent.getY()))
                        .findFirst().ifPresent(shape -> shape.setSize(paintModel.getSize()));


                updateCanvas();
            }
        }




            //System.out.println(paintModel.shapes.get(0).isInsideArea(mouseEvent.getX(), mouseEvent.getY()));










    }

    private void updateCanvas() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (var shape : paintModel.shapes) {
            shape.draw(context);
        }
    }

    public void onUndoAction(ActionEvent event) {

        paintModel.undoShape();
        updateCanvas();
    }



    public void save(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV","*.csv"));

        File filePath = fileChooser.showSaveDialog(stage);

        if(filePath != null)
            paintModel.saveToFile(filePath.toPath());

    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void open(ActionEvent event) {
        //TODO
    }


}

