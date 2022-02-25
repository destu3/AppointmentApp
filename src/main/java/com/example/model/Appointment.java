package com.example.model;

/**
 * Appointments class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Appointment
{

    //Instance variable declaration for appointment class

    // The treatment status for the appointment
    public String Status;

    // The type of service required from the user
    public String Service;

    // The time od the appointment
    public String Time;

    // The date for the appointment
    public String Date;

    // The optician for the appointment
    public Optician optician;


    /**
     * Constructor for Appointment Objects
     *
     */
    public Appointment()
    {
        this.Status = "Pending";
        Service = "Eye Check";
        Time = "00:00";
        Date = "Current Date";
    }

    /**
     * Constructor for objects of class Appointment
     *
     * @param service  treatment status
     * @param time     Service required
     * @param time     decided time for appointment
     * @param date     decided date for appointment
     */
    public Appointment(String Status , String service, String time, String date)
    {
        this.Status = "Pending";
        this.Service = service;
        this.Time = time;
        this.Date = date;
    }

    /**
     * returns the treatment status
     *
     * @return  the status
     */
    public String getStatus() {return Status;}

    /**
     * returns the Service
     *
     * @return  service
     */
    public String getService () {return Service;}

    /**
     * returns the appointment date
     *
     * @return  appointment date
     */
    public String getDate () {return Date;}

    /**
     * returns the appointment time
     *
     * @return  appointment time
     */
    public String getTime () {return Time;}

}


