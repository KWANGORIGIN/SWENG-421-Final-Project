package oscilloscopePackage; /**
 * WaveLength.java
 * This is a Ruler class to indicate the wavelength of the drawn wave
 * @author William Hemminger
 * 30 April 2021
 */

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

        int distance = 0;
        //System.out.println(sourceWave);

        if(sourceWave instanceof WaveDecorator)
        {
            return;
        }

        distance = (int) ((420 / sourceWave.getArg("Frequency").getValue()) *
                (0.015 / sourceWave.getArg("Scale").getValue()));

        this.title = "Wavelength: " + (299792458.0 / sourceWave.getArg("Frequency").getValue()) + "m";

        if(distance > 0)
        {
            this.xEnd = xStart + distance;
        }

    }

    protected void drawTitle(Graphics g)
    {
        g.setFont(new Font("Courier", Font.PLAIN, 14));
        g.drawString(this.title, 5, 15);
    }

}
