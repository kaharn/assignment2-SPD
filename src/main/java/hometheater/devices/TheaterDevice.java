package hometheater.devices;

import java.util.Objects;
import java.util.function.Consumer;

abstract class TheaterDevice {
    private final Consumer<String> output;

    TheaterDevice(Consumer<String> output) {
        this.output = Objects.requireNonNull(output, "output must not be null");
    }

    protected final void log(String message) {
        output.accept(message);
    }
}
