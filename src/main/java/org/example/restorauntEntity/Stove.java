package org.example.restorauntEntity;

import java.util.concurrent.Semaphore;

public class Stove {
    Semaphore semaphore;

    public Stove(int permits) {
        this.semaphore = new Semaphore(permits);
    }

    public boolean tryToCook() {
        return semaphore.tryAcquire();
    }

    public void releaseTheStove() {
        semaphore.release();
    }

    public int getAvailiableSpots() {
        return semaphore.availablePermits();
    }
}
