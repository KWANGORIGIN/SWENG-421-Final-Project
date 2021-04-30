import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

public interface WaveIF {
    WaveArgIF getArg(String arg);
    void changeArg(WaveArgIF arg);
    void plotWave(WaveArgIF argChanged);
    void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data);
    BufferedImage getWaveImage();
    Hashtable<String, WaveArgIF> getData();
    Polygon getPoints();
}
