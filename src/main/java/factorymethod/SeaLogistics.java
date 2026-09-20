package main.java.factorymethod;

public class SeaLogistics extends Logistics {

    @Override

    public Transport createTransport() {

        return new Ship();

    }

}