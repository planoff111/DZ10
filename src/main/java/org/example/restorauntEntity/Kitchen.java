package org.example.restorauntEntity;

import org.example.dishes.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kitchen {


    public HashMap<String, Dish> getDish(){
        HashMap<String, Dish> listDish = new HashMap<>();
        listDish.put("паста",new Dish("Паста",150,true,true,
                List.of("Макарони","Моцарела","Соус Болоньєз"),false,false));
        listDish.put("вареники",new Dish("Вареники",50,false,false,
                List.of("Тісто","Начинка","Масло"),true,false));
        listDish.put("салат греческий",new Dish("Салат Греческий",75,false,false,
                List.of("Оливки","Фета","Салат","Оливкова олія"),false,true));
        listDish.put("борщ",new Dish("Борщ",200,false,true,
                List.of("Вода","Мясо","Буряк","Морква","Картопля","Зажарка"),false,false));
        listDish.put("уха",new Dish("Уха",75,false,false,
                List.of("Риба","Вода","Картопля"),true,false));
        listDish.put("різотто",new Dish("Різотто",175,true,true,
                List.of("Рис","Соуc для Різотто","Сир","Вода"),false,false));
        listDish.put("салат від шефа",new Dish("Салат від Шефа",250,true,true,
                List.of("Секретні інгрідієнти","Секретний соус"),false,false));
        listDish.put("картопля фрі",new Dish("Картопля Фрі",90,true,false,
                List.of("Картопля","Олія","Кетчуп фірмовий"),true,false));

        return listDish;
    }

    public List<String> listOfSauses(){
        List<String> sauses = new ArrayList<>();
        sauses.add("Соус Болоньєз");
        sauses.add("Соуc для Різотто");
        sauses.add("Секретний соус");


        return sauses;
    }
}
