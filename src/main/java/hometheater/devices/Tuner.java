package hometheater.devices;

import java.util.function.Consumer;

public final class Tuner extends TheaterDevice {
    public Tuner(Consumer<String> output) { super(output); }
    public void on() { log("Tuner on"); }
    public void off() { log("Tuner off"); }
    public void setFrequency(double frequency) { log("Tuner frequency set to " + frequency + " FM"); }
}
