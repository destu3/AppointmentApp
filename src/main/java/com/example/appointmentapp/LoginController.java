package com.example.appointmentapp;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File logoFile = new File("gcuOpticiansLogo/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
    }

    public void loginButtonOnAction(ActionEvent event){

        boolean emptyUsername = usernameTextField.getText().isBlank();
        boolean emptyPassword = enterPasswordField.getText().isBlank();

        if ((emptyUsername || emptyPassword))
        {
            loginMessageLabel.setText("Please enter a username and a password");
        }
        else
        {

        }

    }

    public void cancelButtonOnAction (ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}