package org.debz.model;

import java.util.Date;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 1:49 PM
 */
public class Member {

    public long  sid;
    public String surname, other_names, gender, phone_number, id_number, creator, uuid, voided, voided_by;
    public Date date_created, date_voided;

    public String getVoided() {
        return voided;
    }

    public void setVoided(String voided) {
        this.voided = voided;
    }

    public String getVoided_by() {
        return voided_by;
    }

    public void setVoided_by(String voided_by) {
        this.voided_by = voided_by;
    }

    public Date getDate_voided() {
        return date_voided;
    }

    public void setDate_voided(Date date_voided) {
        this.date_voided = date_voided;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOther_names() {
        return other_names;
    }

    public void setOther_names(String other_names) {
        this.other_names = other_names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }
}
