package org.example.data;

import org.example.dishes.*;
import org.example.employees.BarMan;
import org.example.employees.Chief;
import org.example.employees.Cook;
import org.example.restorauntEntity.Bar;
import org.example.restorauntEntity.Kitchen;
import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {

    public HashMap<String, Integer> chiefOrder(HashMap<String, Integer> order,
                                               Chief chief, HashMap<String, Dish> dishes) {
        HashMap<String, Integer> validOrder = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();
            dishes.entrySet().stream()
                    .filter(dish -> dish.getKey().equals(itemName))
                    .filter(dish -> dish.getValue().isFromChief())
                    .map(dish -> dish.getValue().getIngridients())
                    .forEach(dish -> System.out.println("Страва " + dishes.get(itemName).getName() + " від Шефа " +
                            chief.imBoss().getName() + (" Список інгрідієнтів для Шефа " + dishes.get(itemName).getIngridients())));
            validOrder.put(itemName, quantity);

        }
        return validOrder;
    }

    public HashMap<String, Integer> hotProcess(HashMap<String, Integer> order,
                                               List<Cook> cooks, HashMap<String, Dish> dishes) {
        HashMap<String, Integer> validOrder = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();
            dishes.entrySet().stream()
                    .filter(dish -> dish.getKey().equals(itemName))
                    .filter(dish -> dish.getValue().isHotProcess())
                    .map(dish -> dish.getValue().getIngridients())
                    .forEach(dish -> {
                        System.out.println("Страва " + dishes.get(itemName).getName() +
                                " На гарячому процессі:");

                        for (Cook cook : cooks) {
                            if (cook.isHotProcess()) {
                                System.out.println("Повар: " + cook.getName() + " " + cook.getPosition());
                            }
                        }

                        System.out.println("Список інгрідієнтів для повара: " + dishes.get(itemName).getIngridients() +
                                " Кількість: " + quantity);
                    });

            validOrder.put(itemName, quantity);
        }
        return validOrder;
    }

    public HashMap<String, Integer> coldProcess(HashMap<String, Integer> order,
                                                List<Cook> cooks, HashMap<String, Dish> dishes) {
        HashMap<String, Integer> validOrder = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();
            dishes.entrySet().stream()
                    .filter(dish -> dish.getKey().equals(itemName))
                    .filter(dish -> dish.getValue().isColdProcess())
                    .map(dish -> dish.getValue().getIngridients())
                    .forEach(dish -> {
                        System.out.println("Страва " + dishes.get(itemName).getName() +
                                " На холодному процесі :");

                        for (Cook cook : cooks) {
                            if (cook.isColdProcess()) {
                                System.out.println("Повар: " + cook.getName() + " " + cook.getPosition());
                            }
                        }
                        System.out.println("Список інгрідієнтів для повара: " + dishes.get(itemName).getIngridients() +
                                " Кількість: " + quantity);
                    });

            validOrder.put(itemName, quantity);
        }
        return validOrder;
    }

    public HashMap<String, Integer> haveSause(HashMap<String, Integer> order,
                                              List<Cook> cooks, HashMap<String, Dish> dishes) {
        HashMap<String, Integer> validOrder = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();
            dishes.entrySet().stream()
                    .filter(dish -> dish.getKey().equals(itemName))
                    .filter(dish -> dish.getValue().isHaveSause())
                    .map(dish -> dish.getValue().getIngridients())
                    .forEach(dish -> {
                        System.out.println("Страва " + dishes.get(itemName).getName() +
                                " Має соус. Повар, який готує соус: ");

                        for (Cook cook : cooks) {
                            if (cook.isCookingSauce()) {
                                System.out.println("Повар: " + cook.getName() + " " + cook.getPosition());
                            }
                        }
                    });

            validOrder.put(itemName, quantity);
        }
        return validOrder;
    }


    public HashMap<String, Integer> barItems(HashMap<String, Integer> order, HashMap<String, Drink> drinks, BarMan barMan) {
        HashMap<String, Integer> validOrder = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();
            drinks.entrySet().stream()
                    .filter(drink -> drink.getKey().equals(itemName))
                    .map(drink -> drink.getValue().getIngridients())
                    .forEach(drink -> System.out.println("Напій: " + drinks.get(itemName).getName() +
                            " Замовлення йде на бар готуватись " +
                            barMan.barMan().getPosition() + " " + barMan.barMan().getName() +
                            " Прийняв замовлення" + " Список інгрідієнтів для бармена "
                            + drinks.get(itemName).getIngridients() + " Кількість: " + quantity)
                    );
            validOrder.put(itemName, quantity);
        }
        return validOrder;
    }

    public List<String> nonValidOrder(HashMap<String, Integer> orders,
                                                  HashMap<String, Integer> validOrders){
        List<String> nonValidOrder = orders.keySet()
                .stream()
                .filter(validOrder -> !validOrders.containsKey(orders))
                .collect(Collectors.toList());


        return nonValidOrder;
    }
    public void nonValidOrderView(List<String> orders){

        System.out.println("Позиції, що не додані до ордеру " + String.join(", ", orders));
    }


    public HashMap<String, Integer> formOrder(HashMap<String, Integer> chief,HashMap<String, Integer> cold,
                                              HashMap<String, Integer> hot,HashMap<String, Integer> sause,
                                              HashMap<String, Integer> bar){
        HashMap<String, Integer> validOrder = new HashMap<>();
        validOrder.putAll(chief);
        validOrder.putAll(cold);
        validOrder.putAll(hot);
        validOrder.putAll(sause);
        validOrder.putAll(bar);

        return validOrder;
    }


    public HashMap<String, Item> getPriceMenu() {
        Kitchen kitchen = new Kitchen();
        Bar bar = new Bar();
        HashMap<String, Item> menu = new HashMap<>();

        menu.putAll(bar.listDrink());

        menu.putAll(kitchen.getDish());

        return menu;
    }

}
