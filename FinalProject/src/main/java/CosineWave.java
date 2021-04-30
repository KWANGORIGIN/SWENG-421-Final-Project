import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import static java.lang.Math.*;

import static java.lang.Math.sin;

public class CosineWave extends Wave{

    public CosineWave(){
        super();
        plotWave(new ScaleArg(0.015));
    }

    public CosineWave(Hashtable<String, WaveArgIF> data, BufferedImage image, Polygon points){
        super(data, image, points);

//        System.out.println("ACLONE: " + this.getArg("Amplitude").getValue());
//        System.out.println("FCLONE: " + this.getArg("Frequency").getValue());
//        System.out.println("HCLONE: " + this.getArg("Horizontal Shift").getValue());
//        System.out.println("VCLONE: " + this.getArg("Vertical Shift").getValue());
    }


    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data) {
        System.out.println("DrawWave CosineWave Wave");

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

//        System.out.println("A: " + amplitude);
//        System.out.println("F: " + frequency);
//        System.out.println("H: " + horizontalShift);
//        System.out.println("V: " + verticalShift);
//        System.out.println("S: " + scale);



        this.points.reset();
        for (int x = -210; x <= 210; x++) {
            this.points.addPoint(((x + 210)), (int) (150 - ((amplitude * cos(((x * scale) + horizontalShift)*frequency)
                    + verticalShift) / scale)));
        }

        //Gets graphics for image and draws on it
        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);
        imageGraphics.setColor(Color.red);
        imageGraphics.drawPolyline(this.points.xpoints, this.points.ypoints, this.points.npoints);
    }

    @Override
    public BufferedImage getWaveImage() {
        System.out.println(this.getArg("Amplitude").getValue());
        System.out.println("HEREIMAGE");
        return this.image;
    }

    @Override
    public WaveIF cloneWave(){
        return new CosineWave(this.data, this.image, this.points);
    }
}
