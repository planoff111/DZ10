package org.example.employees;

public class BarMan extends Employee implements MakeACocktail {


    public BarMan() {
    }

    public BarMan(String name,String position) {
        super(name,position);
    }


    public BarMan barMan(){

        return new BarMan("Олександр","Бармен");
    }

    @Override
    public void makeCocktail() {

    }

}
