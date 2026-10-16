package hometheater.devices;

import java.util.function.Consumer;

public final class TheaterLights extends TheaterDevice {
    public TheaterLights(Consumer<String> output) { super(output); }
    public void dim(int level) { log("Theater lights dimming to " + level + "%"); }
    public void on() { log("Theater lights on"); }
}
