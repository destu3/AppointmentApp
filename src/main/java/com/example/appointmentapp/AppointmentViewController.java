package com.example.appointmentapp;

import com.example.model.Appointment;
import com.example.model.Optician;
import com.example.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentViewController  implements Initializable {

    @FXML
    private Button bookButton;
    @FXML
    private TextField serviceInput;
    @FXML
    private TextField dateInput;
    @FXML
    private TextField timeInput;
    @FXML
    private Button cancelAppointment;
    @FXML
    private ImageView logoImageView;
    @FXML
    public ImageView appointmentLogoView;
    @FXML
    private TableView<Appointment> tvAppointmentsDeatils;
    @FXML
    private TableColumn<Appointment, String> tcStatus;
    @FXML
    private TableColumn<Appointment, String> tcService;
    @FXML
    private TableColumn<Appointment, String> tcDate;
    @FXML
    private TableColumn<Appointment, String> tcTime;
    @FXML
    private Label opticiansName, opticiansName1;
    @FXML
    private Label opticiansSpeciality, opticiansSpeciality1;
    @FXML
    private Label patientsName;

    Patient patient;
    Optician optician;
    Optician optician1;

    //array of appointment objects
    private final Appointment[] Appointments = {};

    //Observable array list created for appointments
    private final ObservableList<Appointment> appointments = FXCollections.observableArrayList(Appointments);


    public void getPatientDetails (String fullname, String username, String password)
    {
        patient = new Patient(fullname, username, password,true);
        patientsName.setText(patient.getFullName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //how to display data (fields) on the table column cell
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        tcService.setCellValueFactory(new PropertyValueFactory<>("Service"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tcTime.setCellValueFactory(new PropertyValueFactory<>("Time"));


       optician = new Optician("Dr Smith", "Dispensing optician", "smith01");
       optician1 = new Optician("Dr Patterson", "Oculoplastic surgeon", "patterson02");

       opticiansName.setText(optician.getName() +":" );
       opticiansSpeciality.setText(optician.getExpertise());

       opticiansName1.setText(optician1.getName() +":");
       opticiansSpeciality1.setText(optician1.getExpertise());

        File logoFile = new File("gcuOpticiansLogo/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);

        File appointmentLogoFile = new File("gcuOpticiansLogo/appointmentlogo.png");
        Image appointmentLogo = new Image(appointmentLogoFile.toURI().toString());
        appointmentLogoView.setImage(appointmentLogo);

    }

    public void bookAppointment(ActionEvent event)
    {
        appointments.add(new Appointment(patient, optician, Appointment.defaultStatus,serviceInput.getText(), timeInput.getText(),dateInput.getText()));
        tvAppointmentsDeatils.setItems(appointments);
    }

    @FXML
    private void cancelAppointment(ActionEvent event)
    {
        int selectedAppointmentID = tvAppointmentsDeatils.getSelectionModel().getSelectedIndex();
        tvAppointmentsDeatils.getItems().remove(selectedAppointmentID);
    }


}
