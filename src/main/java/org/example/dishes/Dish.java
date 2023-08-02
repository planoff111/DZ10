package org.example.dishes;

import java.util.List;

public class Dish extends Item {
    private boolean haveSause;
    private boolean fromChief;
    private List<String> ingridients;
    private boolean hotProcess;
    private boolean coldProcess;

    public Dish(String name, double price, boolean haveSause, boolean fromChief, List<String> ingridients, boolean hotProcess, boolean coldProcess) {
        super(name, price);
        this.haveSause = haveSause;
        this.fromChief = fromChief;
        this.ingridients = ingridients;
        this.hotProcess = hotProcess;
        this.coldProcess = coldProcess;
    }

    public boolean isHaveSause() {
        return haveSause;
    }


    public boolean isFromChief() {
        return fromChief;
    }


    public List<String> getIngridients() {
        return ingridients;
    }


    public boolean isHotProcess() {
        return hotProcess;
    }


    public boolean isColdProcess() {
        return coldProcess;
    }

}
