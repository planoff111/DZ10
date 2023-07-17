package org.example.employees;

public class Employee {

    private String name;
    private String position;

    public Employee() {
    }

    public Employee(String name, String pisition) {
        this.name = name;
        this.position = pisition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return name  + " " +
                position;
    }
}
