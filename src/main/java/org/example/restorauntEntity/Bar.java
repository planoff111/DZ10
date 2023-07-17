package org.example.restorauntEntity;

import org.example.dishes.Drink;

import java.util.HashMap;
import java.util.List;

public class Bar {

    public HashMap<String, Drink> listDrink(){
        HashMap<String,Drink> list = new HashMap<>();
        list.put("мохіто",new Drink("Мохіто",80,true,false, List.of("Лайм","Мята",
                "Вода","Цукор","Спрайт")));
        list.put("лимонад",new Drink("Лимонад",70,true,false, List.of("Лимон",
                "Вода","Цукор")));
        list.put("чай",new Drink("Чай",50,false,true, List.of("Листя чаю", "Вода","Цукор")));
        list.put("кава",new Drink("Кава",65,false,true, List.of("Кавові зерна", "Вода","Цукор")));


        return list;
    }
}
