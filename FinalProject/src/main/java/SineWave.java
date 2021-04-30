import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import static java.lang.Math.sin;

public class SineWave extends Wave{

    public SineWave(){
        super();
        plotWave(new ScaleArg(0.015));
    }

    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data){

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

        //Polygon wave = new Polygon();
        points.reset();
        for (int x = -210; x <= 210; x++) {
//            wave.addPoint(x + 210, 150 - (int) (scale * Math.sin((x / 210.0) * 2 * Math.PI)));
            //wave.addPoint(((x + 210)), (int) (150 + (amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift)));
            this.points.addPoint(((x + 210)), (int) (150 - ((amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift) / scale)));
            //wave.addPoint((int)((x - 210) * scale), (int) (150 - (amplitude * sin(((x * scale) + horizontalShift)*frequency) + verticalShift)));
//            System.out.println("X: " + (x + 210) + ", Y: " + ((int) (amplitude * Math.sin((x / 210.0) * 2 * Math.PI))));
        }

        //Gets graphics for image and draws on it
        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);
        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(this.points.xpoints, this.points.ypoints, this.points.npoints);
    }

    @Override
    public BufferedImage getWaveImage() {
        return this.image;
    }
}
