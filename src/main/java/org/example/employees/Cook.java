package org.example.employees;

import java.util.ArrayList;
import java.util.List;

public class Cook extends Employee implements SauseMaiker, Frying, Cookaible {

    private boolean isHotProcess;
    private boolean isColdProcess;
    private boolean isCookingSauce;

    public Cook() {
    }

    public Cook(String name, String pisition, boolean isHotProcess, boolean isColdProcess, boolean isCookingSause) {
        super(name, pisition);
        this.isHotProcess = isHotProcess;
        this.isColdProcess = isColdProcess;
        this.isCookingSauce = isCookingSause;
    }

    public boolean isHotProcess() {
        return isHotProcess;
    }

    public void setHotProcess(boolean hotProcess) {
        isHotProcess = hotProcess;
    }

    public boolean isColdProcess() {
        return isColdProcess;
    }

    public void setColdProcess(boolean coldProcess) {
        isColdProcess = coldProcess;
    }

    public boolean isCookingSauce() {
        return isCookingSauce;
    }

    public void setCookingSauce(boolean cookingSauce) {
        isCookingSauce = cookingSauce;
    }

    @Override
    public void cocking() {

    }

    @Override
    public void frying() {

    }

    @Override
    public void makeASause() {

    }

    public List<Cook>listOfCook(){
        List<Cook> list = new ArrayList<>();
        list.add(new Cook("Петро","Соусьє",false,false,true));
        list.add(new Cook("Євген","Кухар",true,false,false));
        list.add(new Cook("Вахтанг","Салатьє",false,true,false));


        return list;
    }
}
