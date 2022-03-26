package com.example.appointmentapp;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
import java.util.Scanner;

public class LoginController implements Initializable {
    //This class controls everything that happens on the login window, it is linked to login.fxml

    //Fields for LoginController class.
    public Button loginButton;
    @FXML
    private Button registerButton;
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

    private Scanner scanner;
    private Scanner Scanner;
    private String patientsFullName;
    private String patientsUsername;
    private String patientsPassword;

    //logos are created and displayed.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File logoFile = new File("gcuOpticiansLogo/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
    }

    //method for when login button is clicked.
    public void loginButtonOnAction(ActionEvent event)  {

        //local variables for this method.
        boolean emptyUsername = usernameTextField.getText().isBlank();
        boolean emptyPassword = enterPasswordField.getText().isBlank();
        String username = usernameTextField.getText();
        String password = enterPasswordField.getText();
        String filepath = "src/main/resources/accounts.csv";


        if (emptyPassword || emptyUsername)
        {
            loginMessageLabel.setText("Fill in all fields");
        }
        else {
            verifyLogin(username,password, filepath);
        }
    }

    //method for verifying login.
    public void verifyLogin(String username, String Password, String filepath)
    {
        String searchTerm = usernameTextField.getText();
        boolean found = false;

        //The scanner object checks the database (accounts.csv) to see if it can find any data that matches the patients inputted username and password.
        try
        {
            scanner = new Scanner(new File(filepath));
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext() && !found)
            {
                String tempUsername = scanner.next();
                String tempPassword = scanner.next();
                String tempFullName = scanner.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(Password.trim())) {
                    found = true;

                    readPatient(searchTerm, filepath);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AppointmentView.fxml"));
                    Parent root = loader.load();

                    AppointmentViewController appointmentViewController = loader.getController();
                    appointmentViewController.getPatientDetails(patientsFullName,patientsUsername,patientsPassword);

                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root, 990,728));
                    stage.show();

                    Stage loginStage = (Stage) loginButton.getScene().getWindow();
                    loginStage.close();
                }
                else
                {
                    loginMessageLabel.setText("User not found. Register now");
                }
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method that retrieves the patients details from the database (accounts.csv) based on the inputted username
    public void readPatient(String searchTerm, String filepath){

        boolean Found = false;

        try {
            Scanner = new Scanner(new File(filepath));
            Scanner.useDelimiter("[,\n]");

            //.hasNext basically means is there anything else to read in the file
            //reads each value in the text file up until each comma for each field
            //basically reads each line while separating the field
            while (Scanner.hasNext() && !Found )
            {
                String Username = Scanner.next();
                String Password = Scanner.next();
                String FullName = Scanner.next();

                patientsFullName = FullName;
                patientsUsername = Username;
                patientsPassword = Password;

                if(Username.equals(searchTerm))
                {
                    Found = true;
                    System.out.println("full name:" + FullName);
                    System.out.println("username:" + Username);
                    System.out.println("password:" + Password);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("error");
        }
    }

    //method for when the close button is clicked. The window is closed.
    public void cancelButtonOnAction (ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //Method for when the Register button is clicked. Register window is displayed.
    public void registerButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(fxmlLoader.load(), 600, 517));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}