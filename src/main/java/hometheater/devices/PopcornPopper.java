package hometheater.devices;

import java.util.function.Consumer;

public final class PopcornPopper extends TheaterDevice {
    public PopcornPopper(Consumer<String> output) { super(output); }
    public void on() { log("Popcorn popper on"); }
    public void pop() { log("Popcorn popper popping popcorn"); }
    public void off() { log("Popcorn popper off"); }
}
