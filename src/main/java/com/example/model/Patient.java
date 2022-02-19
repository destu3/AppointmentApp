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
   public String FirstName;

   // Array to hold appointments
   private Appointment[] appointments;

   // Maximum amount of appointments
    private final int max_appointments = 5;

   // The number of appointments
    public int NumberOfAppointments;

   //Surname of patient
   public String Surname;

   // Patients Registration Status
   public boolean Registered;

   // The patients account username
   public String Username;

   // The patients account password
   public String Password;

   // The patients unique identifier
   public int UserID;



   /** Constructor STILL TO BE CODED PROPERLY, the patients firstname and surname will be the values they choose during the registration process*/

   /**
     * Constructor for Patient Object
     *
     * @param FirstName The patients First Name
     * @param Surname The patients surname
     * @param Registered An indication whether the patient is registered or not
     */

   public Patient(String FirstName, String Surname, boolean Registered)
   {
       appointments = new Appointment[max_appointments];
       NumberOfAppointments = 0;
       this.FirstName = FirstName;
       this.Surname = Surname;
       this.Registered = Registered;
   }

   public Patient()
   {
       appointments = new Appointment[max_appointments];
       NumberOfAppointments = 0;
       this.FirstName = "FirstName";
       this.Surname = "Surname";
       this.Registered = false;
   }

   /**
     * Displays the patients details
     *
     * @return Firstname and Surname
     */
    public String displayDetails ()
    {
        System.out.format("Patient Details - %s\n", FirstName + " " + Surname);
        return this.FirstName + "" + Surname;
    }

    /**
     * Displays patients registration Status
     *
     * @return
     */
    public void getRegistrationStatus ()
    {
        if (Registered == true)
        {
            System.out.format("This patient is registered and can book appointments\n");
        }
        else System.out.format("Patient is not registered. Please Sign up now\n");
    }

    /**
     * Displays the number of appointments
     *
     * @return NumberOfAppointments
     */
    public int getNumberOfAppointments()
    {
        System.out.format("Current number of appointments is: %s\n" , NumberOfAppointments);
        return NumberOfAppointments;
    }

    /**
     * Prints information about the account and any current appointments
     *
     */
    public String viewAppointments()
    {
        System.out.format("Firstname: %s\nSurname: %s\n", FirstName, Surname);

        for(int i=0;i<NumberOfAppointments;i++)
        {
            Appointment appointment = appointments[i];

            System.out.format("%s   %s    %s    %s\n",
                    appointment.getStatus(),
                    appointment.getService(),
                    appointment.getTime(),
                    appointment.getDate());
        }
        return  "";
    }

    /**
     * Adds a new appointment as long as the maximum of 5 has not been reached
     *
     */
    public String bookAppointment(Appointment newAppointment)
    {
        if(NumberOfAppointments < max_appointments)
        {
            appointments[NumberOfAppointments] = newAppointment;
            NumberOfAppointments++;
        }

        System.out.format("Appointment successfully booked %s\n" , newAppointment);
        return "";

    }



    /** Registration code will go in here */
    public void Register ()
    {


    }

    /** Login code will go in here */
    public void Login ()
    {


    }


}
   
   
