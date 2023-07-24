package org.example.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waitress extends Employee {
    public Waitress() {
    }


    public Waitress(String name, String pisition) {
        super(name, pisition);

    }




    public String chooseWaitress(List list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex).toString();

    }



}
