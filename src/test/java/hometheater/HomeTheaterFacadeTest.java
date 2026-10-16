package hometheater;

import hometheater.devices.Amplifier;
import hometheater.devices.PopcornPopper;
import hometheater.devices.Projector;
import hometheater.devices.Screen;
import hometheater.devices.StreamingPlayer;
import hometheater.devices.TheaterLights;
import hometheater.devices.Tuner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/** Lightweight automated tests that run without external test libraries. */
public final class HomeTheaterFacadeTest {
    private HomeTheaterFacadeTest() { }

    public static void main(String[] args) {
        movieWorkflowRunsDevicesInOrder();
        radioWorkflowRunsDevicesInOrder();
        blankMovieTitleIsRejectedBeforeAnyDeviceRuns();
        invalidRadioFrequencyIsRejectedBeforeAnyDeviceRuns();
        System.out.println("All Home Theater facade tests passed.");
    }

    private static void movieWorkflowRunsDevicesInOrder() {
        List<String> commands = new ArrayList<>();
        HomeTheaterFacade theater = createTheater(commands::add);
        theater.watchMovie("Arrival");
        assertEquals(List.of(
                "Popcorn popper on", "Popcorn popper popping popcorn",
                "Theater lights dimming to 10%", "Screen down", "Projector on",
                "Projector widescreen mode (16:9)", "Streaming player on", "Amplifier on",
                "Amplifier connected to streaming player", "Amplifier surround sound on",
                "Amplifier volume set to 5", "Streaming player playing \"Arrival\""), commands,
                "movie startup command order");

        commands.clear();
        theater.endMovie();
        assertEquals(List.of("Popcorn popper off", "Theater lights on", "Screen up",
                "Projector off", "Streaming player off", "Amplifier off"), commands,
                "movie shutdown command order");
    }

    private static void radioWorkflowRunsDevicesInOrder() {
        List<String> commands = new ArrayList<>();
        HomeTheaterFacade theater = createTheater(commands::add);
        theater.listenToRadio(97.5);
        assertEquals(List.of("Tuner on", "Tuner frequency set to 97.5 FM", "Amplifier on",
                "Amplifier connected to tuner", "Amplifier stereo sound on",
                "Amplifier volume set to 5"), commands, "radio startup command order");

        commands.clear();
        theater.endRadio();
        assertEquals(List.of("Tuner off", "Amplifier off"), commands,
                "radio shutdown command order");
    }

    private static void blankMovieTitleIsRejectedBeforeAnyDeviceRuns() {
        List<String> commands = new ArrayList<>();
        expectIllegalArgument(() -> createTheater(commands::add).watchMovie("  "));
        assertEquals(List.of(), commands, "commands after invalid movie title");
    }

    private static void invalidRadioFrequencyIsRejectedBeforeAnyDeviceRuns() {
        for (double frequency : new double[]{0, -1, Double.NaN, Double.POSITIVE_INFINITY}) {
            List<String> commands = new ArrayList<>();
            expectIllegalArgument(() -> createTheater(commands::add).listenToRadio(frequency));
            assertEquals(List.of(), commands, "commands after invalid radio frequency");
        }
    }

    private static HomeTheaterFacade createTheater(Consumer<String> output) {
        StreamingPlayer player = new StreamingPlayer(output);
        return new HomeTheaterFacade(new Amplifier(output), player,
                new Projector(output), new TheaterLights(output), new Screen(output),
                new PopcornPopper(output), new Tuner(output));
    }

    private static void expectIllegalArgument(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException");
    }

    private static void assertEquals(Object expected, Object actual, String description) {
        if (!expected.equals(actual)) {
            throw new AssertionError(description + " expected " + expected + " but got " + actual);
        }
    }
}
