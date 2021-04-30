import java.awt.*;

public class PPAmplitude extends VerticalRuler {

    public PPAmplitude()
    {
        this.title = "PPAmp: ";
        this.xStart = 5;
        this.xEnd = 5;
    }

    @Override
    public void calculateEndpoint(WaveIF sourceWave) {
        Polygon points = sourceWave.getPoints();
        int[] yPoints = points.ypoints;

        int distance = 0;
        int max = points.ypoints[0];
        int min = points.ypoints[0];


        for (int i = 1; i < points.ypoints.length; i++)
        {
            //System.out.println(points.ypoints[i]);
            if (points.ypoints[i] > max); //note that greater than in this case means lower on the graph
            {
                max = points.ypoints[i];
            }

            if(points.ypoints[i] < min)
            {
                min = points.ypoints[i];
            }
        }
//
//        System.out.println(max);
//        System.out.println(min);

       distance = max - min;
        yStart = min;
        yEnd = min + (2 * distance);

        this.title = "PPAmp: " + (2 * sourceWave.getArg("Amplitude").getValue());
    }

    protected void drawTitle(Graphics g)
    {
        g.setFont(new Font("Courier", Font.PLAIN, 12));
        g.drawString(this.title, 15, 280);
    }
}
