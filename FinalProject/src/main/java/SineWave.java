import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.sin;

public class SineWave extends Wave{

    public SineWave(){
        super();
        plotWave(new ScaleArg(0.015));
    }

    @Override
    public void plotWave(WaveArgIF argChanged) {
//        System.out.println(data);

        //Resets image to black background
        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.black);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        System.out.println("Plot wave being called...");
        System.out.println(argChanged.getType() + " " + argChanged.getValue());

        //putting new argument into hashtable
        String argType = argChanged.getType();

        System.out.println(argType);
        data.remove(argType);
        data.put(argType, argChanged);


//        //Logic for drawing wave itself
//        double amplitude = data.get("Amplitude").getValue() / 10.0;
//        int frequency = (int) data.get("Frequency").getValue();
//        double scale = (data.get("Scale").getValue() * 0.0001)  * (1000.0 / 301);
//        System.out.println(scale);
//        double horizontalShift = data.get("Horizontal Shift").getValue() * (421 / (double) (100) * scale);
//        double verticalShift = data.get("Vertical Shift").getValue() * (301 / (double) 100 * scale);


        //Logic for drawing wave itself
        double amplitude = data.get("Amplitude").getValue();
        int frequency = (int) data.get("Frequency").getValue();
        double scale = data.get("Scale").getValue();
        double horizontalShift = data.get("Horizontal Shift").getValue();
        double verticalShift = data.get("Vertical Shift").getValue();

        Polygon wave = new Polygon();
        for (int x = -210; x <= 210; x++) {
//            wave.addPoint(x + 210, 150 - (int) (scale * Math.sin((x / 210.0) * 2 * Math.PI)));
            //wave.addPoint(((x + 210)), (int) (150 + (amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift)));
            wave.addPoint(((x + 210)), (int) (150 - ((amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift) / scale)));
            //wave.addPoint((int)((x - 210) * scale), (int) (150 - (amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift)));
//            System.out.println("X: " + (x + 210) + ", Y: " + ((int) (amplitude * Math.sin((x / 210.0) * 2 * Math.PI))));
        }

        //Gets graphics for image and draws on it
        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);
        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(wave.xpoints, wave.ypoints, wave.npoints);

        setChanged();
        notifyObservers();

        System.out.println("Size: " + this.countObservers() + " from: " + Thread.currentThread());
//        System.out.println(this);

        //Cleans up Graphics from memory
        imageGraphics.dispose();
    }

    @Override
    public BufferedImage getWaveImage() {
        return this.image;
    }
}
