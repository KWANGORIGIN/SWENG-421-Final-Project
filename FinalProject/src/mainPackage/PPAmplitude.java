package mainPackage; /**
 * PPAmplitude.java
 * This is a ruler object to display the Peak to Peak amplitude on the drawn wave
 * @author William Hemminger
 * 30 April 2021
 */

import java.awt.*;

public class PPAmplitude extends VerticalRuler {

    public PPAmplitude()
    {
        super(0, 5);
        this.title = "PPAmp: ";
        this.identifier = "PPAmp";
    }

    @Override
    public void calculateEndpoint(WaveIF sourceWave) {

        int distance = 0;
        int max = sourceWave.getPoints().ypoints[0];
        int min = sourceWave.getPoints().ypoints[0];


        for (int i = 1; i < 420; i++)
        {
            try
            {
                if (sourceWave.getPoints().ypoints[i] > max) //note that greater than in this case means lower on the graph
                {
                    max = sourceWave.getPoints().ypoints[i];
                }

                if(sourceWave.getPoints().ypoints[i] < min)
                {
                    min = sourceWave.getPoints().ypoints[i];
                }
            } catch(IndexOutOfBoundsException e)
            {
                //array does not contain enough data
            }

        }


        distance = max - min;
        yStart = min;
        yEnd = min + distance;

        this.title = "PPAmp: " + (2 * sourceWave.getArg("Amplitude").getValue());
    }

    protected void drawTitle(Graphics g)
    {
        g.setFont(new Font("Courier", Font.PLAIN, 14));
        g.drawString(this.title, 15, 280);
    }
}
