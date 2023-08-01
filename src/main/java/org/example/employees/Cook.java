package org.example.employees;

import org.example.dishes.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cook extends Employee {

    private boolean isHotProcess;
    private boolean isColdProcess;
    private boolean isCookingSauce;
    Dish dish;

    public Cook() {
    }

    public Cook(String name, String pisition, boolean isHotProcess, boolean isColdProcess, boolean isCookingSause) {
        super(name, pisition);
        this.isHotProcess = isHotProcess;
        this.isColdProcess = isColdProcess;
        this.isCookingSauce = isCookingSause;
    }

    public boolean isHotProcess() {
        return isHotProcess;
    }

    public boolean isColdProcess() {
        return isColdProcess;
    }

    public boolean isCookingSauce() {
        return isCookingSauce;
    }

    public String cookHot(HashMap<String, Dish> dishes,String itemName){
        return "Страва " + dishes.get(itemName).getName() +
                " На гарячому процессі:";
    }

    public String cookCold(HashMap<String, Dish> dishes,String itemName){
        return "Страва " + dishes.get(itemName).getName() +
                " На холодному процесі :";
    }

    public String cookSause(HashMap<String, Dish> dishes,String itemName){
        return "Страва " + dishes.get(itemName).getName() +
                " Має соус. Повар, який готує соус: ";
    }

}
