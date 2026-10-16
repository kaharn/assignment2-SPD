package hometheater;

import hometheater.devices.Amplifier;
import hometheater.devices.PopcornPopper;
import hometheater.devices.Projector;
import hometheater.devices.Screen;
import hometheater.devices.StreamingPlayer;
import hometheater.devices.TheaterLights;
import hometheater.devices.Tuner;

public final class Main {
    private Main() { }

    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade(
                new Amplifier(System.out::println),
                new StreamingPlayer(System.out::println),
                new Projector(System.out::println),
                new TheaterLights(System.out::println),
                new Screen(System.out::println),
                new PopcornPopper(System.out::println),
                new Tuner(System.out::println));

        theater.watchMovie("Raiders of the Lost Ark");
        theater.endMovie();
        theater.listenToRadio( FM_FREQUENCY );
        theater.endRadio();
    }

    private static final double FM_FREQUENCY = 97.5;
}
