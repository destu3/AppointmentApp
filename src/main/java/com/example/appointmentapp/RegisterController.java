package com.example.appointmentapp;

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
    //This class controls everything that happens on the register window, it is linked to register.fxml

    //Fields for RegisterController class.
    @FXML
    private Button closeButton;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField fullNameTextField;
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

    //logos are created and displayed.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File logoFile = new File("gcuOpticiansLogo/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
    }

    //method for when the register button is clicked.
    public void registerButtonOnAction(ActionEvent event)
    {
        //local variables for this method
        boolean emptyFullName = fullNameTextField.getText().isBlank();
        boolean emptyUsername = usernameTextField.getText().isBlank();
        boolean emptyPassword = enterPasswordField.getText().isBlank();
        boolean emptyConfirmPassword = confirmPasswordField.getText().isBlank();
        boolean unmatchingPassword = !enterPasswordField.getText().equals(confirmPasswordField.getText());

        //makes sure all fields are filled out when the patient is registering
        if (emptyFullName || emptyUsername || emptyPassword || emptyConfirmPassword)  {
            registerMessageLabel.setText("Fill in all fields");
            unmatchingPasswordsMessageLabel.setText("");
            successfulRegistrationMessageLabel.setText("");
        }
        //makes sure that the password is confirmed
        else if (unmatchingPassword)
        {
            unmatchingPasswordsMessageLabel.setText("Passwords must match");
            registerMessageLabel.setText("");
            successfulRegistrationMessageLabel.setText("");
        }

        else {

            //Writes the patients inputted data to the database (accounts.csv)
            try {
                FileWriter fw = new FileWriter("src/main/resources/accounts.csv", true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(usernameTextField.getText() + "," + enterPasswordField.getText() + "," + fullNameTextField.getText());
                pw.close();
                successfulRegistrationMessageLabel.setText("Successfully Registered, Log in now");
                registerMessageLabel.setText("");
                unmatchingPasswordsMessageLabel.setText("");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.print("file write function failed");
            }
        }
    }

    //Method for when the login button is clicked. login window is displayed.
    public void loginButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

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
