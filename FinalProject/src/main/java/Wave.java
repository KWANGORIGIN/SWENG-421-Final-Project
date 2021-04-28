import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Observable;
import java.util.concurrent.locks.ReadWriteLock;

public abstract class Wave extends Observable implements WaveIF {
    protected Hashtable<String, WaveArgIF> data;
    protected ReadWriteLock lockManager;
    protected static BufferedImage image;

    public Wave(){
        data = new Hashtable<>();

        AmpArg amplitude = new AmpArg(0);
        FreqArg frequency = new FreqArg(0);
        HorizArg horizontal = new HorizArg(0);
        VertArg vertical = new VertArg(0);

        data.put(amplitude.getType(), amplitude);
        data.put(frequency.getType(), frequency);
        data.put(horizontal.getType(), horizontal);
        data.put(vertical.getType(), vertical);

        image = new BufferedImage(420, 300, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public Hashtable<String, WaveArgIF> getData() {
        return this.data;
    }
}
