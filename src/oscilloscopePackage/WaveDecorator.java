package oscilloscopePackage; /**
 * WaveDecorator.java
 * This is a decorator class to wrap a Wave object with a ruler
 * @author William Hemminger
 * 30 April 2021
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class WaveDecorator extends Wave{
    protected WaveIF sourceWave;
    private RulerIF ruler;


    public WaveDecorator(RulerIF addedRuler, WaveIF sourceWave)
    {
        this.ruler = addedRuler;
        this.sourceWave = sourceWave;
        this.changeArg(sourceWave.getArg("Scale"));
    }

    @Override
    public void plotWave(WaveArgIF argChanged)
    {
        this.sourceWave.plotWave(argChanged);

        if(argChanged instanceof ScaleArg)
        {
            this.changeArg(this.sourceWave.getArg("Scale"));
        }

    }

    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data) {

        this.sourceWave.drawWave(imageGraphics, data);

    }

    @Override
    public BufferedImage getWaveImage() {

        image = this.getRootWave().getWaveImage();
        WaveIF iterator = this;
        while(iterator instanceof WaveDecorator)
        {
            ((WaveDecorator) iterator).ruler.plotRuler(getRootWave());
            iterator = ((WaveDecorator) iterator).sourceWave;
        }

        return this.image;


    }

    @Override
    public WaveIF cloneWave() {

        return new WaveDecorator(this.ruler, sourceWave);
    }

    public RulerIF getRuler()
    {
        return this.ruler;
    }

    public WaveIF getSourceWave()
    {
        return this.sourceWave;
    }

    public WaveIF getRootWave()
    {
        if(this.sourceWave instanceof WaveDecorator)
        {
            return ((WaveDecorator) this.sourceWave).getRootWave();
        }
        else
        {
            return this.sourceWave;
        }
    }

    public WaveIF rewrap(String exclude)
    {
        WaveIF newWave = this.getRootWave();

        WaveIF iterator = this;
        while(iterator instanceof WaveDecorator)
        {
            if(!(((WaveDecorator) iterator).getRuler().getIdentifier().equals(exclude)))
            {
                newWave = new WaveDecorator((((WaveDecorator) iterator).getRuler()), newWave);
            }

            iterator = ((WaveDecorator) iterator).sourceWave;
        }

        newWave.getWaveImage();
        newWave.plotWave(new AmpArg(this.getRootWave().getArg("Amplitude").getValue()));

        return newWave;
    }
}
