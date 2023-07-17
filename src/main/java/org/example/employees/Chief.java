package org.example.employees;

public class Chief extends Cook {

    public Chief() {
    }

    private boolean chiefDish;

    public Chief(String name, String pisition, boolean isHotProcess, boolean isColdProcess,
                 boolean isCookingSause, boolean chiefDish) {
        super(name, pisition, isHotProcess, isColdProcess, isCookingSause);
        this.chiefDish = chiefDish;
    }

    public Chief imBoss(){

        return new Chief("Рамзі","",false,false,false,true);
    }

    public boolean isChiefDish() {
        return chiefDish;
    }
}
