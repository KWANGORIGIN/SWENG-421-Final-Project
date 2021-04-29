import java.awt.image.BufferedImage;
import java.util.Hashtable;

public interface WaveIF {
    WaveArgIF getArg(String arg);
    void changeArg(WaveArgIF arg);
    void plotWave(WaveArgIF argChanged);
    BufferedImage getWaveImage();
    Hashtable<String, WaveArgIF> getData();
}
