package com.paintcnlabb.labb3;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SvgWriter {

    FileChooser fileChooser = new FileChooser();
    List<String> svgStrings = new ArrayList<>();

    public void save(PaintModel paintModel, Stage stage) {

        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG File", "*.svg"));
        File filePath = fileChooser.showSaveDialog(stage);

        buildSvgString(paintModel);

        try {
            assert filePath != null;
            Files.write(filePath.toPath(), svgStrings);
        }
        catch (Exception ignored) {
        }
    }

    private void buildSvgString(PaintModel paintModel) {
        svgStrings.add("<svg width=\"800.0\" height=\"600.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        paintModel.shapes.forEach(shape -> svgStrings.add(shape.writeSVG()));
        svgStrings.add("</svg>");
    }
}
