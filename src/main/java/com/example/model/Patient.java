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
        System.out.format("Patient Details - %s", FirstName + " " + Surname);
        
        return "Patient details displayed";
    }

    public static void main(String[] args)
    {
        Patient patient1 = new Patient("Destiny", "Uduebholo",false);
        patient1.displayDetails();
    }
    
    
    
    
    

  

}
   
   
