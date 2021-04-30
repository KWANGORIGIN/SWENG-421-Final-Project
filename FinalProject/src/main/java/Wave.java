import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Math.sin;

public abstract class Wave implements WaveIF {
    protected Hashtable<String, WaveArgIF> data;
    protected BufferedImage image;
    protected Polygon points;

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
        points = new Polygon();
    }

    @Override
    public void plotWave(WaveArgIF argChanged){
        //Resets image to black background
        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.black);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());

//        System.out.println("Plot wave being called...");
//        System.out.println(argChanged.getType() + " " + argChanged.getValue());
//
//        System.out.println("Number of observers in argChanged: " + argChanged.getObservers().size());

        //putting new argument into hashtable
        changeArg(argChanged);

        drawWave(imageGraphics, data);

        if(!argChanged.hasChanged()){
            argChanged.setChanged();
            argChanged.notifyObservers(argChanged);
        }

        //Cleans up Graphics from memory
        imageGraphics.dispose();
    }

    @Override
    public Hashtable<String, WaveArgIF> getData() {
        return this.data;
    }

    @Override
    public void changeArg(WaveArgIF arg){
        if(arg.isShared() && data.get(arg.getType()).getObservers().size() != 0){
            ArrayList<ObserverIF> observers = data.get(arg.getType()).getObservers();
            arg.setObservers(observers);
//            System.out.println("Observers: " + observers.size());
        }
        data.remove(arg.getType());
        data.put(arg.getType(), arg);
    }

    @Override
    public WaveArgIF getArg(String arg){
        return data.get(arg);
    }

    @Override
    public Polygon getPoints(){
        return this.points;
    }
}
