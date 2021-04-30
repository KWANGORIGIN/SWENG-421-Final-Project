import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Math.sin;

public abstract class Wave implements WaveIF{
    protected Hashtable<String, WaveArgIF> data;
    protected BufferedImage image;
    protected Polygon points;
    protected WaveIF sourceWave;

    public Wave(){
        data = new Hashtable<>();

        AmpArg amplitude = new AmpArg(2);
        FreqArg frequency = new FreqArg(2);
        HorizArg horizontal = new HorizArg(0);
        VertArg vertical = new VertArg(0);
        ScaleArg scale = new ScaleArg(0.015);

        data.put(amplitude.getType(), amplitude);
        data.put(frequency.getType(), frequency);
        data.put(horizontal.getType(), horizontal);
        data.put(vertical.getType(), vertical);
        data.put(scale.getType(), scale);

        image = new BufferedImage(420, 300, BufferedImage.TYPE_INT_RGB);
        points = new Polygon();
        System.out.println("NEW WAVE");
    }

    public Wave(Hashtable<String, WaveArgIF> data, BufferedImage image, Polygon points){
        this.data = new Hashtable<String, WaveArgIF>();
        this.data.put("Amplitude", data.get("Amplitude").cloneArg());
        this.data.put("Frequency", data.get("Frequency").cloneArg());
        this.data.put("Horizontal Shift", data.get("Horizontal Shift").cloneArg());
        this.data.put("Vertical Shift", data.get("Vertical Shift").cloneArg());
        this.data.put("Scale", data.get("Scale").cloneArg());
        this.image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = this.image.getGraphics();
        g.drawImage(image, 0, 0, null);
        this.points = new Polygon(points.xpoints, points.ypoints, points.npoints);

//        double amplitude = data.get("Amplitude").getValue();
//        int frequency = (int) data.get("Frequency").getValue();
//        double scale = data.get("Scale").getValue();
//        double horizontalShift = data.get("Horizontal Shift").getValue();
//        double verticalShift = data.get("Vertical Shift").getValue();
//
//        System.out.println("\nA: " + amplitude);
//        System.out.println("F: " + frequency);
//        System.out.println("H: " + horizontalShift);
//        System.out.println("V: " + verticalShift);
//        System.out.println("S: " + scale);
    }

    @Override
    public void plotWave(WaveArgIF argChanged){
        //Resets image to black background

        //WHY DOES THIS BREAK WITH THE DECORATOR OBJECT?????

        System.out.println("PLOTTING WAVE");
        double amplitude = data.get("Amplitude").getValue();
        int frequency = (int) data.get("Frequency").getValue();
        double scale = data.get("Scale").getValue();
        double horizontalShift = data.get("Horizontal Shift").getValue();
        double verticalShift = data.get("Vertical Shift").getValue();

        System.out.println("\nA: " + amplitude);
        System.out.println("F: " + frequency);
        System.out.println("H: " + horizontalShift);
        System.out.println("V: " + verticalShift);
        System.out.println("S: " + scale);

        System.out.println(this);
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
