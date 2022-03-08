package com.example.appointmentapp;

import com.example.model.Patient;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ResourceBundle;
import java.net.URL;

public class RegisterController implements Initializable {


    @FXML
    private Button closeButton;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private Label unmatchingPasswordsMessageLabel;
    @FXML
    private Label successfulRegistrationMessageLabel;


    Patient patient = new Patient();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File logoFile = new File("gcuOpticiansLogo/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
    }

    public void registerButtonOnAction(ActionEvent event)
    {
        boolean emptyFirstName = firstnameTextField.getText().isBlank();
        boolean emptyLastName = lastnameTextField.getText().isBlank();
        boolean emptyUsername = usernameTextField.getText().isBlank();
        boolean emptyPassword = enterPasswordField.getText().isBlank();
        boolean emptyConfirmPassword = confirmPasswordField.getText().isBlank();
        boolean unmatchingPassword = !enterPasswordField.getText().equals(confirmPasswordField.getText());

        if (emptyFirstName || emptyLastName || emptyUsername || emptyPassword || emptyConfirmPassword)  {
            registerMessageLabel.setText("No empty fields allowed");

        }
        else if (unmatchingPassword)
        {
            unmatchingPasswordsMessageLabel.setText("Passwords must match");
            registerMessageLabel.setText("");
        }

        else {
            registerMessageLabel.setText("");
            unmatchingPasswordsMessageLabel.setText("");

            try {
                FileWriter fw = new FileWriter("src/main/resources/file1.csv", true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(usernameTextField.getText() + "," + enterPasswordField.getText() );
                pw.close();
                successfulRegistrationMessageLabel.setText("Successfully Registered, Log in now");

                patient.FirstName = firstnameTextField.getText();
                patient.Surname = lastnameTextField.getText();
                patient.Registered = true;
                patient.Username = usernameTextField.getText();
                patient.Password = enterPasswordField.getText();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loginButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        createLoginWindow();

    }


    public void createLoginWindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
            Stage LoginStage = new Stage();
            LoginStage.initStyle(StageStyle.UNDECORATED);
            LoginStage.setScene(new Scene(fxmlLoader.load(), 520, 456));
            LoginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

}
