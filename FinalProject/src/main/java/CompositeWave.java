import jdk.jshell.spi.ExecutionControl;

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
            System.out.println("WaveInfo:\n Amplitude: " + w.getData().get("Amplitude"));
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
        System.out.println("GETTING IMAGE");
        BufferedImage combined = new BufferedImage(420, 300, BufferedImage.TYPE_INT_ARGB);

        Graphics imageGraphics = combined.getGraphics();
        imageGraphics.setColor(Color.black);
        imageGraphics.fillRect(0, 0, combined.getWidth(), combined.getHeight());

        imageGraphics.setColor(Color.green);
        imageGraphics.drawLine(0, 150, 420, 150);


        System.out.println("HERE");
        Polygon tempPoints;

//        g.drawImage(this.waves.get(0).getWaveImage(), 0, 0, null);

        for(int i = 0; i < waves.size(); i++)
        {
            tempPoints = waves.get(i).getPoints();


            imageGraphics.setColor(colors[i]);
            imageGraphics.drawPolyline(tempPoints.xpoints, tempPoints.ypoints, tempPoints.npoints);

            System.out.println("Amplitude: " + waves.get(i).getArg("Amplitude"));
            System.out.println("Amplitude: " + waves.get(i).getArg("Frequency"));
            System.out.println("Adding Image...");
            //imageGraphics.drawImage(w.getWaveImage(), 50, 50, null);
        }

        return combined;
    }

    public Hashtable<String, WaveArgIF> getData()
    {
        return this.waves.get(0).getData();
    }

    public void addWave(WaveIF addedWave)
    {
        if(waves.size() < 5)
        {
            this.waves.add(addedWave);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wave cap reached!");
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
}
