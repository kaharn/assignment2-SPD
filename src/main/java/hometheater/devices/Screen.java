package hometheater.devices;

import java.util.function.Consumer;

public final class Screen extends TheaterDevice {
    public Screen(Consumer<String> output) { super(output); }
    public void down() { log("Screen down"); }
    public void up() { log("Screen up"); }
}
