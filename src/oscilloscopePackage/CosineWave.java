package oscilloscopePackage; /**
 * Cosine.java
 * This is the class for the Cosine wave object
 * @author William Hemminger
 * 30 April 2021
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import static java.lang.Math.*;

public class CosineWave extends Wave{

    public CosineWave()
    {}

    public CosineWave(Hashtable<String, WaveArgIF> data, BufferedImage image, Polygon points){
        super(data, image, points);
    }


    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data) {

        //Logic for drawing wave itself
        double amplitude = data.get("Amplitude").getValue();
        int frequency = (int) data.get("Frequency").getValue();
        double scale = data.get("Scale").getValue();
        double horizontalShift = data.get("Horizontal Shift").getValue();
        double verticalShift = data.get("Vertical Shift").getValue();


        this.points.reset();
        for (int x = -210; x <= 210; x++) {
            this.points.addPoint(((x + 210)), (int) (150 - ((amplitude * cos(((x * scale) + horizontalShift)*frequency)
                    + verticalShift) / scale)));
        }

        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(this.points.xpoints, this.points.ypoints, this.points.npoints);
    }

    @Override
    public BufferedImage getWaveImage() {
        return this.image;
    }

    @Override
    public WaveIF cloneWave(){
        return new CosineWave(this.data, this.image, this.points);
    }
}
