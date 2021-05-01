import java.awt.*;

public class Wavelength extends HorizontalRuler{

    public Wavelength()
    {
        super(10, 20);
        this.title = "Wavelength: ";
        this.identifier = "Wavelength";
    }

    @Override
    public void calculateEndpoint(WaveIF sourceWave) {
        Polygon points = sourceWave.getPoints();

        int distance = 0;
        //System.out.println(sourceWave);

        if(sourceWave instanceof WaveDecorator)
        {
            return;
        }

        distance = (int) ((420 / sourceWave.getArg("Frequency").getValue()) *
                (0.015 / sourceWave.getArg("Scale").getValue()));

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
