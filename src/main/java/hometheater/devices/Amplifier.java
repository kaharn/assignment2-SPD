package hometheater.devices;

import java.util.function.Consumer;

public final class Amplifier extends TheaterDevice {
    public Amplifier(Consumer<String> output) { super(output); }
    public void on() { log("Amplifier on"); }
    public void off() { log("Amplifier off"); }
    public void setStreamingPlayer(StreamingPlayer player) { log("Amplifier connected to streaming player"); }
    public void setTuner(Tuner tuner) { log("Amplifier connected to tuner"); }
    public void setSurroundSound() { log("Amplifier surround sound on"); }
    public void setStereoSound() { log("Amplifier stereo sound on"); }
    public void setVolume(int level) { log("Amplifier volume set to " + level); }
}
