module com.example.appointmentapp {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appointmentapp to javafx.fxml;
    exports com.example.appointmentapp;
}