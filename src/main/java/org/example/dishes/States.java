package org.example.dishes;

public enum States {
    BOLED("Bolied", 1), FRIED("Fried", 2), CHOPPED("Chopped", 3),
    WITH_SAUCE("WithSauce", 4),SALAT_MAKES("Salat makes",5);


    public final int number;
    public final String state;

    States(String state,int number) {
        this.number = number;
        this.state = state;
    }
}
