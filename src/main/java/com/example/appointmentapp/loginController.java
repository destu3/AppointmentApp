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

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;

public class loginController implements Initializable {

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

        boolean emptyUsername = usernameTextField.getText().isBlank() == true;
        boolean emptyPassword = enterPasswordField.getText().isBlank() == true;

        if ((emptyUsername && emptyPassword) || (emptyUsername || emptyPassword))
        {
            loginMessageLabel.setText("Please enter a username and a password");
        }
        else
        {
            validateLogin();
        }

    }

    public void cancelButtonOnAction (ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin ()
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM patient_account WHERE username = '" + usernameTextField.getText() + "' AND password ='" + enterPasswordField.getText() +  "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next())
            {
                if (queryResult.getInt(1) == 1)
                {
                    loginMessageLabel.setText("This will open appointments form");
                }
                else
                {
                    loginMessageLabel.setText("invalid login, please try again :)");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}