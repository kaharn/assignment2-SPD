package main.java;

import main.java.abstractfactory.Application;
import main.java.abstractfactory.GUIFactory;
import main.java.abstractfactory.MacFactory;
import main.java.abstractfactory.WindowsFactory;

import main.java.factorymethod.Logistics;
import main.java.factorymethod.RoadLogistics;
import main.java.factorymethod.SeaLogistics;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Factory Method ===");

        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();

        System.out.println("\n=== Abstract Factory ===");

        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);

        System.out.println("Windows application:");
        windowsApp.render();

        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);

        System.out.println("MacOS application:");
        macApp.render();
    }
}