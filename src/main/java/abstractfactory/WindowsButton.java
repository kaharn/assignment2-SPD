package main.java.abstractfactory;

public class WindowsButton implements Button {

    @Override

    public void render() {

        System.out.println("Rendering Windows button.");

    }

}