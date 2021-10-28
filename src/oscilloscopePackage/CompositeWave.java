package oscilloscopePackage; /**
 * CompositeWave.java
 * This class is a container for many different waves that can be drawn together
 * @author William Hemminger
 * 30 April 2021
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;

public class CompositeWave implements WaveIF{


    private ArrayList<WaveIF> waves;

    public CompositeWave()
    {
        this.waves = new ArrayList<WaveIF>();
    }

    public CompositeWave(WaveIF sourceWave)
    {
        this.waves = new ArrayList<WaveIF>();
        this.waves.add(sourceWave);
    }

    public void plotWave(WaveArgIF argChanged)
    {

        this.waves.get(this.waves.size() - 1).plotWave(argChanged);
        for(WaveIF w : this.waves)
        {
            if(argChanged instanceof ScaleArg)
            {
                w.plotWave(argChanged);
            }
        }
    }

    @Override
    public WaveArgIF getArg(String arg) {
        return null;
    }

    @Override
    public void changeArg(WaveArgIF arg) {

    }

    @Override
    public void drawWave(Graphics imageGraphics, Hashtable<String, WaveArgIF> data) {

    }

    public BufferedImage getWaveImage()
    {
        Color colors [] = {Color.RED, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.PINK};
        BufferedImage combined = new BufferedImage(420, 300, BufferedImage.TYPE_INT_ARGB);

        Graphics imageGraphics = combined.getGraphics();
        imageGraphics.setColor(Color.black);
        imageGraphics.fillRect(0, 0, combined.getWidth(), combined.getHeight());

        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);

        Polygon tempPoints;

        for(int i = 0; i < waves.size(); i++)
        {
            tempPoints = waves.get(i).getPoints();


            imageGraphics.setColor(colors[i]);
            imageGraphics.drawPolyline(tempPoints.xpoints, tempPoints.ypoints, tempPoints.npoints);
        }

        return combined;
    }

    public Hashtable<String, WaveArgIF> getData()
    {
        return this.waves.get(0).getData();
    }

    public void addWave(WaveIF addedWave)
    {
        if(waves.size() == 5)
        {
            JOptionPane.showMessageDialog(null, "Wave cap reached!");
        }
        else
        {
            this.waves.add(addedWave);
        }

    }

    public Polygon getPoints()
    {
        return null;
    }

    public WaveIF getLast()
    {
        return this.waves.get((waves.size() - 1));
    }

    public WaveIF cloneWave()
    {
        return null;
    }

    public void clear()
    {
        this.waves.clear();
    }

    public ArrayList<WaveIF> getWaves()
    {
        return this.waves;
    }
}
