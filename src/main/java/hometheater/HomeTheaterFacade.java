package hometheater;

import hometheater.devices.Amplifier;
import hometheater.devices.PopcornPopper;
import hometheater.devices.Projector;
import hometheater.devices.Screen;
import hometheater.devices.StreamingPlayer;
import hometheater.devices.TheaterLights;
import hometheater.devices.Tuner;

import java.util.Objects;

/** Offers simple movie and radio operations over the home theater subsystem. */
public final class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final StreamingPlayer player;
    private final Projector projector;
    private final TheaterLights lights;
    private final Screen screen;
    private final PopcornPopper popper;
    private final Tuner tuner;

    public HomeTheaterFacade(Amplifier amplifier, StreamingPlayer player,
                             Projector projector, TheaterLights lights,
                             Screen screen, PopcornPopper popper, Tuner tuner) {
        this.amplifier = Objects.requireNonNull(amplifier, "amplifier must not be null");
        this.player = Objects.requireNonNull(player, "player must not be null");
        this.projector = Objects.requireNonNull(projector, "projector must not be null");
        this.lights = Objects.requireNonNull(lights, "lights must not be null");
        this.screen = Objects.requireNonNull(screen, "screen must not be null");
        this.popper = Objects.requireNonNull(popper, "popper must not be null");
        this.tuner = Objects.requireNonNull(tuner, "tuner must not be null");
    }

    public void watchMovie(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Movie title must not be blank");
        }
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.setWideScreenMode();
        player.on();
        amplifier.on();
        amplifier.setStreamingPlayer(player);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        player.play(title);
    }

    public void endMovie() {
        System.out.println("Shutting down the movie theater...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        player.off();
        amplifier.off();
    }

    public void listenToRadio(double frequency) {
        if (!Double.isFinite(frequency) || frequency <= 0) {
            throw new IllegalArgumentException("Radio frequency must be a positive finite number");
        }
        System.out.println("Tuning in the theater radio...");
        tuner.on();
        tuner.setFrequency(frequency);
        amplifier.on();
        amplifier.setTuner(tuner);
        amplifier.setStereoSound();
        amplifier.setVolume(5);
    }

    public void endRadio() {
        System.out.println("Turning off the theater radio...");
        tuner.off();
        amplifier.off();
    }
}
