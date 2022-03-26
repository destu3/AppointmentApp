package com.example.model;

public class Optician {

    private String name;
    private String Expertise;
    private String OpticianID;

    public Optician(String name, String expertise, String opticianID) {
        this.name = name;
        this.Expertise = expertise;
        this.OpticianID = opticianID;
    }

    public Optician() {
        this.name = "";
        this.Expertise = "";
        this.OpticianID = "";
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return Expertise;
    }

    public String getOpticianID() {
        return OpticianID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) {
        Expertise = expertise;
    }

    public void setOpticianID(String opticianID) {
        OpticianID = opticianID;
    }

    @Override
    public String toString() {
        return "Optician{" +
                "name='" + name + '\'' +
                ", Expertise='" + Expertise + '\'' +
                ", OpticianID='" + OpticianID + '\'' +
                '}';
    }
}
