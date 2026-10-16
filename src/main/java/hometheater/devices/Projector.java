package hometheater.devices;

import java.util.function.Consumer;

public final class Projector extends TheaterDevice {
    public Projector(Consumer<String> output) { super(output); }
    public void on() { log("Projector on"); }
    public void off() { log("Projector off"); }
    public void setWideScreenMode() { log("Projector widescreen mode (16:9)"); }
}
