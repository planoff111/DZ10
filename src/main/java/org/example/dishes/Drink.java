package org.example.dishes;

import java.util.List;

public class Drink extends Item{

    private boolean cold;
    private boolean hot;
    List<String> ingridients;

    public Drink() {
    }

    public Drink(String name, double price, boolean cold, boolean hot, List<String> ingridients) {
        super(name, price);
        this.cold = cold;
        this.hot = hot;
        this.ingridients = ingridients;
    }

    public boolean isCold() {
        return cold;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public List<String> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<String> ingridients) {
        this.ingridients = ingridients;
    }
}
