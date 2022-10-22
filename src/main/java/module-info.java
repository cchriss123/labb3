module com.paintcnlabb.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.paintcnlabb.labb3 to javafx.fxml;
    exports com.paintcnlabb.labb3;
}