package org.example.restorauntEntity;

import org.example.dishes.Dish;
import org.example.dishes.Drink;
import org.example.dishes.Item;
import org.example.dishes.States;
import org.example.employees.BarMan;
import org.example.employees.Chief;
import org.example.employees.Cook;
import org.example.employees.Waitress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kitchen {
    Cook cook;
    Zal zal;
    Kitchen kitchen;


    public HashMap<String, Dish> getDish(){
        HashMap<String, Dish> listDish = new HashMap<>();
        listDish.put("паста",new Dish("Паста",150,true,true,
                List.of("Макарони","Моцарела","Соус Болоньєз"),false,false,
                List.of(States.BOLED,States.WITH_SAUCE)));
        listDish.put("вареники",new Dish("Вареники",50,false,false,
                List.of("Тісто","Начинка","Масло"),true,false,List.of(States.BOLED)));
        listDish.put("салат греческий",new Dish("Салат Греческий",75,false,false,
                List.of("Оливки","Фета","Салат","Оливкова олія"),false,true,
                List.of(States.SALAT_MAKES)));
        listDish.put("борщ",new Dish("Борщ",200,false,true,
                List.of("Вода","Мясо","Буряк","Морква","Картопля","Зажарка"),false,false,
                List.of(States.BOLED)));
        listDish.put("уха",new Dish("Уха",75,false,false,
                List.of("Риба","Вода","Картопля"),true,false,
                List.of(States.BOLED)));
        listDish.put("різотто",new Dish("Різотто",175,true,true,
                List.of("Рис","Соуc для Різотто","Сир","Вода"),false,false,
                List.of(States.WITH_SAUCE)));
        listDish.put("салат від шефа",new Dish("Салат від Шефа",250,true,true,
                List.of("Секретні інгрідієнти","Секретний соус"),false,false,
                List.of(States.SALAT_MAKES,States.WITH_SAUCE)));
        listDish.put("картопля фрі",new Dish("Картопля Фрі",90,true,false,
                List.of("Картопля","Олія","Кетчуп фірмовий"),true,false,
                List.of(States.WITH_SAUCE,States.FRIED)));


        return listDish;
    }


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
                        System.out.println(cook.cookHot(kitchen.getDish(),itemName));

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
                        System.out.println(cook.cookCold(kitchen.getDish(),itemName));

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
                        System.out.println(cook.cookSause(kitchen.getDish(),itemName));

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

    public List<Cook>listOfCook(){
        List<Cook> list = new ArrayList<>();
        list.add(new Cook("Петро","Соусьє",false,false,true));
        list.add(new Cook("Євген","Кухар",true,false,false));
        list.add(new Cook("Вахтанг","Салатьє",false,true,false));


        return list;
    }

    public List<Waitress> listofWaitr(){
        List<Waitress> list = new ArrayList<>();
        list.add(new Waitress("Semen","Офіціант"));
        list.add(new Waitress("Ivan","МегаОфіціант"));
        list.add(new Waitress("Petro","Стажер"));

        return list;
    }

}
