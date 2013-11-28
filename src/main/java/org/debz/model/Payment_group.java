package org.debz.model;

import java.util.Date;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 5:20 PM
 */
public class Payment_group {

    public long sid;
    public String  name,uuid;
    public String rate_per_hour;
    public String basic_pay;
    public Date date_created;

    public boolean isVoided() {
        return voided;
    }

    public void setVoided(boolean voided) {
        this.voided = voided;
    }

    public boolean voided;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRate_per_hour() {
        return rate_per_hour;
    }

    public void setRate_per_hour(String rate_per_hour) {
        this.rate_per_hour = rate_per_hour;
    }

    public String getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(String basic_pay) {
        this.basic_pay = basic_pay;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }
}
