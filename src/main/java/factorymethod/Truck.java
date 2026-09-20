package main.java.factorymethod;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivering cargo by truck.");
    }
}