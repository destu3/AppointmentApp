package com.example.model;

/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient
{
   public String FirstName;
   public Appointment Appointmnets;
   public String Surname; 
   public boolean Registered;
   public String Username;
   public String Password;
   
   public Patient(String FirstName, String Surname, boolean Registered)
    {
        // initialise instance variables
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.Registered = Registered;
    }
    
    public String displayDetails ()
    {
        System.out.format("Patient Details - %s\n", FirstName + " " + Surname);
        return "Patient details displayed";
    }

    public void getRegistrationStatus ()
    {
        if (Registered == true)
        {
            System.out.format("This patient is registered and can book appointments\n");
        }
        else System.out.format("Patient is not registered. Please Sign up now\n");
    }

    /** This main method is only to test the method and test commiting and pushing */

    public static void main(String[] args)
    {
        Patient patient1 = new Patient("Destiny", "Uduebholo",false);
        patient1.displayDetails();

        patient1.getRegistrationStatus();
    }
    
    
    
    
    

  

}
   
   
