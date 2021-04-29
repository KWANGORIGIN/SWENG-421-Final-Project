import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Wave implements WaveIF {
    protected Hashtable<String, WaveArgIF> data;
    protected BufferedImage image;

    public Wave(){
        data = new Hashtable<>();

        AmpArg amplitude = new AmpArg(0);
        FreqArg frequency = new FreqArg(0);
        HorizArg horizontal = new HorizArg(0);
        VertArg vertical = new VertArg(0);
        ScaleArg scale = new ScaleArg(0);

        data.put(amplitude.getType(), amplitude);
        data.put(frequency.getType(), frequency);
        data.put(horizontal.getType(), horizontal);
        data.put(vertical.getType(), vertical);
        data.put(scale.getType(), scale);

        image = new BufferedImage(420, 300, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public Hashtable<String, WaveArgIF> getData() {
        return this.data;
    }

    @Override
    public void changeArg(WaveArgIF arg){
//        if(data.get(arg.getType()).getObservers().size() != 0){
        if(arg.isShared() && data.get(arg.getType()).getObservers().size() != 0){
            ArrayList<ObserverIF> observers = data.get(arg.getType()).getObservers();
            arg.setObservers(observers);
            System.out.println("Observers: " + observers.size());
        }
        data.remove(arg.getType());
        data.put(arg.getType(), arg);
    }

    @Override
    public WaveArgIF getArg(String arg){
        return data.get(arg);
    }
}
