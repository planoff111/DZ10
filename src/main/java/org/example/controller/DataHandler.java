package org.example.controller;

import org.example.model.*;

import java.util.*;

public class DataHandler {

    public HashMap<String, Integer> handleOrder(HashMap<String, Integer> order,
                                                HashMap<String, Dish> dishes, HashMap<String, Drink> drinks,
                                                Chief chief, List<Cook> cooks,
                                                List<String> sauses) {
        BarMan barMan = new BarMan();
        HashMap<String, Integer> validOrder = new HashMap<>();
        ArrayList<String> unknownItems = new ArrayList<>();
        boolean coldProcessCooked = false;
        boolean hotProcessCooked = false;
        boolean sauceCooked = false;
        boolean foundDish = false;
        boolean foundDrink = false;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String itemName = entry.getKey().toLowerCase();
            Integer quantity = entry.getValue();

            if (dishes.containsKey(itemName)) {
                Dish dish = dishes.get(itemName);
                List<String> ingredients = dishes.get(itemName).getIngridients();
                if (dish.isFromChief() == chief.isChiefDish()) {
                    System.out.println("Страва "+ dishes.get(itemName).getName()+
                            " Готується " + " Шефом" + " " + chief.imBoss().getName() );
                    System.out.println("Список інгрідієнтів для Шефа " + String.join(" ", ingredients));
                }

                for (Cook cook : cooks) {
                    if (dish.isColdProcess() && !coldProcessCooked && cook.isColdProcess()) {
                        System.out.println("Салат " + dish.getName() + " Готується" + cook.getName() + " " + cook.getPosition());
                        System.out.println("Список інгрідієнтів для повара " + String.join(" ", ingredients));
                        System.out.println("Кількість: " + quantity);
                        coldProcessCooked = true;
                    }
                    if (dish.isHotProcess() && !hotProcessCooked && cook.isHotProcess()) {
                        System.out.println("Страва " + dish.getName() + " На гарячому процессі : " + cook.getName() + " " + cook.getPosition());
                        System.out.println("Список інгрідієнтів для повара " + String.join(" ", ingredients));
                        System.out.println("Кількість: " + quantity);
                        hotProcessCooked = true;
                    }
                    if (dish.isHaveSause() && !sauceCooked && cook.isCookingSauce()) {
                        System.out.println("Робить соус для страви " + dish.getName() + " Повар " + cook.getName() + " " + cook.getPosition());
                        System.out.println("Кількість: " + quantity);
                        sauceCooked = true;
                    }
                }
                foundDish = true;
                validOrder.put(itemName, quantity);
            }

            else if(drinks.containsKey(itemName)){
                Drink drink = drinks.get(itemName);
                List<String> ingredients = drinks.get(itemName).getIngridients();
                System.out.println("Напій: " + drink.getName() + " Замовлення йде на бар готуватись");
                System.out.println("Кількість: " + quantity);
                System.out.println(barMan.barMan().getPosition() + " " + barMan.barMan().getName() + " Прийняв замовлення");
                System.out.println("Список інгрідієнтів для бармена " + String.join(" ", ingredients));
                foundDrink = true;
                validOrder.put(itemName, quantity);

            }
            else {
                unknownItems.add(itemName);
            }
        }


        if (!unknownItems.isEmpty()) {
            System.out.println("Позиції, що не додані до ордеру " + String.join(", ", unknownItems));
        }

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