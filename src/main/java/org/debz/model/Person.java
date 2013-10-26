package org.debz.model;

import java.util.Date;

/**
 * sample Person class
 */
public class Person {

    private Integer id;
    private String names;
    private Date dob;
    private String gender;
    private String occupation;

    //blank constructor
    public Person(){

    }

    public Person(String names,Date dob,String gender,String occupation ){
        this.names = names;
        this.dob = dob;
        this.gender = gender;
        this.occupation = occupation;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
