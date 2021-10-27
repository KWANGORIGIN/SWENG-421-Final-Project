package mainPackage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import static java.lang.Math.sin;

public class SineWave extends Wave{

    public SineWave()
    {}

    public SineWave(Hashtable<String, WaveArgIF> data, BufferedImage image, Polygon points){
        super(data, image, points);
    }


    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data){

        //Logic for drawing wave itself
        double amplitude = data.get("Amplitude").getValue();
        int frequency = (int) data.get("Frequency").getValue();
        double scale = data.get("Scale").getValue();
        double horizontalShift = data.get("Horizontal Shift").getValue();
        double verticalShift = data.get("Vertical Shift").getValue();


         this.points.reset();
        for (int x = -210; x <= 210; x++) {
            this.points.addPoint(((x + 210)), (int) (150 - ((amplitude * sin(((x * scale) + horizontalShift)*frequency)
                    + verticalShift) / scale)));
        }

        //Gets graphics for image and draws on it
        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(this.points.xpoints, this.points.ypoints, this.points.npoints);
    }

    @Override
    public BufferedImage getWaveImage() {
        return this.image;
    }
}
