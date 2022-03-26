package com.example.model;

/**
 * Appointments class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Appointment
{
    // The treatment status for the appointment
    private String Status;

    // Tye default status for appointments
    public static final String defaultStatus = "pending";

    // The type of service required from the user
    private String Service;

    // The time od the appointment
    private String Time;

    // The date for the appointment
    private String Date;

    // The optician for the appointment
    private Optician optician;

    // The patient for the appointment
    private Patient patient;



    /**
     * Constructor for Appointment Objects
     *
     */
    public Appointment() {
        this.Status = defaultStatus;
        this.Service = "";
        this.Time = "";
        this.Date = "";
        this.patient = null;
        this.optician = null;
    }

    /**
     * Constructor for objects of class Appointment
     *
     * @param service  treatment status
     * @param time     Service required
     * @param time     decided time for appointment
     * @param date     decided date for appointment
     */
    public Appointment(Patient patient, Optician optician, String Status,String service, String time, String date)
    {
        this.Status = defaultStatus;
        this.Service = service;
        this.Time = time;
        this.Date = date;
        this.patient = patient;
        this.optician = optician;

    }

    public String getStatus() {
        return Status;
    }

    public String getService() {
        return Service;
    }

    public String getTime() {
        return Time;
    }

    public String getDate() {
        return Date;
    }

    public Optician getOptician() {
        return optician;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setService(String service) {
        Service = service;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setOptician(Optician optician) {
        this.optician = optician;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    @Override
    public String toString() {
        return "Appointment{" +
                "Status='" + Status + '\'' +
                ", Service='" + Service + '\'' +
                ", Time='" + Time + '\'' +
                ", Date='" + Date + '\'' +
                ", optician=" + optician +
                ", patient=" + patient +
                '}';
    }


}


