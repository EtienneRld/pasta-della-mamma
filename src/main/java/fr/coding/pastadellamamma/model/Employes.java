package fr.coding.pastadellamamma.model;

import java.util.Date;

public class Employes {

    public Employes(String name, String firstName, String job){
        this.name = name;
        this.firstName =firstName;
        this.job = job;
    }


    private String name;
    private String firstName;
    private String job;
    private Date table;

    @Override
    public String toString() {
        return "Employes{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", job='" + job + '\'' +
                ", table=" + table +
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
}
