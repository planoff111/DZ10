package org.example.dishes;

import java.util.List;

public class Dish extends Item {
    private boolean haveSause;
    private boolean fromChief;
    private List<String> ingridients;
    private boolean hotProcess;
    private boolean coldProcess;
    private List<States> states;
    public Dish(String name, double price, boolean haveSause, boolean fromChief, List<String> ingridients,
                boolean hotProcess, boolean coldProcess) {
        super(name, price);
        this.haveSause = haveSause;
        this.fromChief = fromChief;
        this.ingridients = ingridients;
        this.hotProcess = hotProcess;
        this.coldProcess = coldProcess;

    }


    public Dish(String name, double price, boolean haveSause, boolean fromChief, List<String> ingridients, boolean hotProcess, boolean coldProcess, List<States> states) {
        super(name, price);
        this.haveSause = haveSause;
        this.fromChief = fromChief;
        this.ingridients = ingridients;
        this.hotProcess = hotProcess;
        this.coldProcess = coldProcess;
        this.states = states;
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
