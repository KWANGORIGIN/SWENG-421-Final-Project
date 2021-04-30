import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;

public class WaveDecorator extends Wave{

    private RulerIF ruler;


    public WaveDecorator(RulerIF addedRuler, WaveIF sourceWave)
    {
        this.ruler = addedRuler;
        this.sourceWave = sourceWave;
    }
    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data) {

//        double amplitude = data.get("Amplitude").getValue();
//        int frequency = (int) data.get("Frequency").getValue();
//        double scale = data.get("Scale").getValue();
//        double horizontalShift = data.get("Horizontal Shift").getValue();
//        double verticalShift = data.get("Vertical Shift").getValue();
//
//        System.out.println("A: " + amplitude);
//        System.out.println("F: " + frequency);
//        System.out.println("H: " + horizontalShift);
//        System.out.println("V: " + verticalShift);
//        System.out.println("S: " + scale);
        this.sourceWave.drawWave(imageGraphics, data);
        /*
        this.drawWave(imageGraphics, data);
        this.ruler.plotRuler(this.sourceWave);
         */
//        WaveIF iterator = this.sourceWave;
//        ArrayList<RulerIF> rulers = new ArrayList<RulerIF>();
//
//        rulers.add(this.getRuler());
//
//        // iterate down to base decorator
//        while(((WaveDecorator)iterator).sourceWave instanceof WaveDecorator)
//        {
//            iterator = ((WaveDecorator) iterator).sourceWave;
//            rulers.add(((WaveDecorator) iterator).getRuler());
//        }
//
//        iterator = ((WaveDecorator) iterator).sourceWave; //iterate down to base wave
//        iterator.drawWave(imageGraphics, data);
//
//        for(RulerIF r : rulers)
//        {
//            System.out.println(((AbstractRuler) r).title);
//            r.plotRuler(iterator);
//        }
    }

    @Override
    public BufferedImage getWaveImage() {
        //System.out.println("HERE DECORATOR");
        this.image = sourceWave.getWaveImage();
        this.ruler.plotRuler(this.sourceWave);

        //System.out.println("RETURNING IMAGE");
        return this.image;
    }

    @Override
    public WaveIF cloneWave() {
        return this.sourceWave.cloneWave();
    }

    public RulerIF getRuler()
    {
        return this.ruler;
    }

    public WaveIF getSourceWave()
    {
        return this.sourceWave;
    }
}