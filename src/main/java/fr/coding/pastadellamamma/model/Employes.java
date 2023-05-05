package fr.coding.pastadellamamma.model;

import java.util.Date;

public class Employes {

    public Employes(String name, String firstName, String job, String hours){
        this.name = name;
        this.firstName =firstName;
        this.job = job;
        this.hours = hours;
    }


    private String name;
    private String firstName;
    private String job;
    private Date table;

    private String hours;


    @Override
    public String toString() {
        return "Employes{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", job='" + job + '\'' +
                ", table='" + table + '\'' +
                ", hours=" + hours +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getJob() {
        return job;
    }

    public Date getTable() {
        return table;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getHours() { return hours; }
}
