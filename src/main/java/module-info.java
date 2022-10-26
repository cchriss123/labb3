module com.paintcnlabb.labbtre {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.paintcnlabb.labb3 to javafx.fxml;
    exports com.paintcnlabb.labb3;
}