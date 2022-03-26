package com.example.model;

/**
 * Patient Class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient
{
    // Firstname of patient
   private String FullName;

   // The patients account username
   private String Username;

   // The patients account password
   private String Password;

   // The number of appointments
   private int NumberOfAppointments;

   // Patients Registration Status
   private boolean Registered;


    /**
     * Constructor for Patient Object
     *
     * @param FullName The patients First Name
     * @param Registered An indication whether the patient is registered or not
     */

   public Patient(String FullName, String Username, String Password, boolean Registered)
   {
       this.FullName = FullName;
       this.Username = Username;
       this.Password = Password;
       NumberOfAppointments = 0;
       this.Registered = Registered;
   }

   public Patient()
   {
       this.FullName = "";
       this.Username = "";
       this.Password = "";
       NumberOfAppointments = 0;
       this.Registered = false;
   }

    public String getFullName() {
        return FullName;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public int getNumberOfAppointments() {
        return NumberOfAppointments;
    }

    public boolean isRegistered() {
        return Registered;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setNumberOfAppointments(int numberOfAppointments) {
        NumberOfAppointments = numberOfAppointments;
    }

    public void setRegistered(boolean registered) {
        Registered = registered;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "FullName='" + FullName + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", NumberOfAppointments=" + NumberOfAppointments +
                ", Registered=" + Registered +
                '}';
    }

}
   
   
