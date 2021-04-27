import java.awt.*;
import java.awt.image.BufferedImage;

public class SineWave extends Wave{

    public SineWave(){
        super();
        plotWave(new AmpArg(0));
    }

    @Override
    public void plotWave(WaveArgIF argChanged) {

        System.out.println("Plot wave being called...");

        //putting new argument into hashtable
        String argType = argChanged.getType();
        data.remove(argType);
        data.put(argType, argChanged);

        //Logic for drawing wave itself
        int amplitude = 50;
        int horizontalShift = 100;
        int verticalShift = 10;
        int frequency = 1;
        Polygon wave = new Polygon();
        for (int x = -210; x <= 210; x++) {
//            wave.addPoint(x + 210, 150 - (int) (scale * Math.sin((x / 210.0) * 2 * Math.PI)));
            wave.addPoint(x + 210, 150 - verticalShift + (int) (amplitude * Math.sin((x / 210.0) * 2 * Math.PI * frequency + horizontalShift)));
//            System.out.println("X: " + (x + 210) + ", Y: " + ((int) (amplitude * Math.sin((x / 210.0) * 2 * Math.PI))));
        }

        //Gets graphics for image and draws on it
        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);
        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(wave.xpoints, wave.ypoints, wave.npoints);

        //Cleans up Graphics from memory
        imageGraphics.dispose();
    }

    @Override
    public BufferedImage getWaveImage() {
        return this.image;
    }
}
