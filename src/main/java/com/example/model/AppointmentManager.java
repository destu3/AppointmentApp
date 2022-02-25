package com.example.model;
import java.util.Scanner;

/**
 * AppointmentManager contains main method
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AppointmentManager {
    // the current patient
    private Patient patient;

    // The scanner reading user input
    private Scanner scanner;

    /**
     * Constructor for AppointmentManager objects
     */
    public AppointmentManager(Patient patient) {
        this.patient = patient;
        scanner = new Scanner(System.in);
    }

    public void Begin() {
        System.out.println("Enter Appointment details");

            //get patient first name
            System.out.print("Please enter your first name\n>");
            String firstName = scanner.nextLine();

            //get patient surname
            System.out.print("Please enter your Surname\n>");
            String surName = scanner.nextLine();

            //get desired service
            System.out.print("What kind of service do your require? We offer a range of services from eye checks, new glasses ,contact lens fitting,to management of eye conditions etc.\n>");
            String desiredService = scanner.nextLine();

            //get desired appointment date
            System.out.print("Please enter your desired appointment date (dd/mm/yyyy)\n>");
            String desiredDate = scanner.nextLine();

            //get preferred appointment time
            System.out.print("Please enter your preferred appointment time\n>");
            String preferredTime = scanner.nextLine();


            String treatmentStatus = "pending";

            Appointment appointment = new Appointment(treatmentStatus, desiredService, preferredTime, desiredDate);
            Patient patient = new Patient(firstName,surName,true);

            patient.bookAppointment(appointment);

            patient.viewAppointments();

            patient.getNumberOfAppointments();
        }


    public static void main(String[] args) {
        Patient patient = new Patient();

        AppointmentManager appointmentManager = new AppointmentManager(patient);

        appointmentManager.Begin();

    }
}

