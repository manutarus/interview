package org.debz.model;

/**
 * Created with IntelliJ IDEA.
 * User: manu
 * Date: 11/10/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Course {
    public long sid;

    public String name;

    public String units;
    public String units_percentage;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits_percentage() {
        return units_percentage;
    }

    public void setUnits_percentage(String units_percentage) {
        this.units_percentage = units_percentage;
    }


    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }



}
