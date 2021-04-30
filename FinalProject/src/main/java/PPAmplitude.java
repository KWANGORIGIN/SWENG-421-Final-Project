import java.awt.*;

public class PPAmplitude extends VerticalRuler {

    public PPAmplitude()
    {
        super(0, 5);
        this.title = "PPAmp: ";
//        this.xStart = 5;
//        this.xEnd = 5;
    }

    @Override
    public void calculateEndpoint(WaveIF sourceWave) {
        System.out.println("SourceWave: " + sourceWave.getPoints().xpoints.length + " " + sourceWave.getPoints().ypoints.length);
        Polygon points = sourceWave.getPoints();
        int[] yPoints = points.ypoints;

        int distance = 0;
        int max = sourceWave.getPoints().ypoints[0];
        int min = sourceWave.getPoints().ypoints[0];


        for (int i = 1; i < 420; i++)
        {
            System.out.println("in loop");
            System.out.println(sourceWave.getPoints().ypoints[i]);
            if (sourceWave.getPoints().ypoints[i] > max) //note that greater than in this case means lower on the graph
            {
                max = sourceWave.getPoints().ypoints[i];
            }

            if(sourceWave.getPoints().ypoints[i] < min)
            {
                min = sourceWave.getPoints().ypoints[i];
            }
        }
//
        System.out.println(max);
        System.out.println(min);

        distance = max - min;
        yStart = min;
        yEnd = min + distance;

        System.out.println("HERE: " + distance);

        this.title = "PPAmp: " + (2 * sourceWave.getArg("Amplitude").getValue());
    }

    protected void drawTitle(Graphics g)
    {
        g.setFont(new Font("Courier", Font.PLAIN, 14));
        g.drawString(this.title, 15, 280);
    }
}
