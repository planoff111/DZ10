package org.example.employees;

public class BarMan extends Employee  {


    public BarMan() {
    }

    public BarMan(String name,String position) {
        super(name,position);
    }


    public BarMan barMan(){

        return new BarMan("Олександр","Бармен");
    }



}
