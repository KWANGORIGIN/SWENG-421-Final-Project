import java.awt.*;

public class Wavelength extends HorizontalRuler{

    public Wavelength()
    {
        super(10, 20);
        this.title = "Wavelength: ";
//        this.xStart = 10;
//        this.yStart = 20;
//        this.yEnd = 20;
    }

    @Override
    public void calculateEndpoint(WaveIF sourceWave) {
        Polygon points = sourceWave.getPoints();
        int [] xPoints = points.ypoints;
        int [] yPoints = points.ypoints;

        int distance = 0;
        //System.out.println(sourceWave);

        if(sourceWave instanceof WaveDecorator)
        {
            return;
        }

//        for(int i = 5; i < points.xpoints.length; i++)
//        {
//            if(yPoints[0] <= yPoints[i] + 1 || yPoints[0] >= yPoints[i] - 1)
//            {
//                System.out.println(points.xpoints[i] + " " + points.xpoints[0]);
//                distance = points.xpoints[i] - points.xpoints[0];
//                System.out.println(distance);
//                break;
//            }
//        }

//        int maxIndex = 0;
//        for(int i = 0; i < points.ypoints.length; i++)
//        {
//            if(points.ypoints[i] > points.ypoints[maxIndex])
//            {
//                maxIndex = i;
//            }
//        }
//
//        for(int i = maxIndex + 1; i < points.ypoints.length; i++)
//        {
//            if(points.ypoints[i] == points.ypoints[maxIndex])
//            {
//                distance = points.xpoints[i] - points.xpoints[maxIndex];
//            }
//        }

        distance = (int) (420 / sourceWave.getArg("Frequency").getValue());

        this.title = "Wavelength: " + (299792458.0 / sourceWave.getArg("Frequency").getValue()) + "m";
        System.out.println("Wavelength: " + (299792458.0 / sourceWave.getArg("Frequency").getValue()) + "m");
       // System.out.println(sourceWave.getArg("Frequency").getValue());

        if(distance > 0)
        {
            System.out.println("distance: " + distance);
            this.xEnd = xStart + distance;

        }

    }

    protected void drawTitle(Graphics g)
    {
        //System.out.println("drawing title");
        g.setFont(new Font("Courier", Font.PLAIN, 14));
        g.drawString(this.title, 5, 15);
    }

}
