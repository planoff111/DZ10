package org.example.employees;

import org.example.dishes.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cook extends Employee implements Runnable{
    Dish dish;

    private boolean isHotProcess;
    private boolean isColdProcess;
    private boolean isCookingSauce;

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

    public void boil(){
        System.out.println(" Вариться страва " + dish.getName());
    }

    public void fry(){
        System.out.println(" Жариться страва " + dish.getName());
    }

    public void chop(){
        System.out.println(" Нарізається страва " + dish.getName());
    }

    public void addSause(){
        System.out.println(" Додається соус у  страву " + dish.getName());
    }
    public void createSalad(){
        System.out.println(" Збирається салат " + dish.getName());
    }
    @Override
    public void run() {

    }
}
