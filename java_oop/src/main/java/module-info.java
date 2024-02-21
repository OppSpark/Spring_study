module com.java_oop.java_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.java_oop.java_oop to javafx.fxml;
    exports com.java_oop.java_oop;
}