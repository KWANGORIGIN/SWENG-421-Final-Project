import java.awt.image.BufferedImage;
import java.util.Hashtable;

public interface WaveIF {
    void plotWave(WaveArgIF argChanged);
    BufferedImage getWaveImage();
    Hashtable<String, WaveArgIF> getData();
}
