package hometheater.devices;

import java.util.function.Consumer;

public final class StreamingPlayer extends TheaterDevice {
    public StreamingPlayer(Consumer<String> output) { super(output); }
    public void on() { log("Streaming player on"); }
    public void off() { log("Streaming player off"); }
    public void play(String title) { log("Streaming player playing \"" + title + "\""); }
}
