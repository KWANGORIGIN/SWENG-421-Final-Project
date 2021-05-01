import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Math.sin;

public abstract class Wave implements WaveIF{
    protected Hashtable<String, WaveArgIF> data;
    protected BufferedImage image;
    protected Polygon points;

    public Wave(){
        data = new Hashtable<>();

        AmpArg amplitude = new AmpArg(0);
        FreqArg frequency = new FreqArg(0);
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

        //this.plotWave(new AmpArg(0));
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
    }

    @Override
    public void plotWave(WaveArgIF argChanged){
        //Resets image to black background

        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.black);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);


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
    protected Object clone() throws CloneNotSupportedException{
        Wave wave = (Wave) super.clone();

        Hashtable<String, WaveArgIF> newData = new Hashtable<>();
        for(WaveArgIF arg : data.values()){
            newData.put(arg.getType(), arg.cloneArg());
        }
        wave.data = newData;

        ColorModel model = image.getColorModel();
        WritableRaster raster = image.copyData(null);
        wave.image = new BufferedImage(model, raster, model.isAlphaPremultiplied(), null);

        wave.points = new Polygon(points.xpoints, points.ypoints, points.npoints);
        return wave;
    }

    @Override
    public WaveIF cloneWave(){
        try{
            return (WaveIF) clone();
        }catch(CloneNotSupportedException e){
            System.out.println("Unable to clone...");
        }
        return null;
    }

    @Override
    public void changeArg(WaveArgIF arg){
        if(arg.isShared() && data.get(arg.getType()).getObservers().size() != 0){
            ArrayList<ObserverIF> observers = data.get(arg.getType()).getObservers();
            arg.setObservers(observers);
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
