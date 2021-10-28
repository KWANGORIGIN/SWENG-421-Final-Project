package oscilloscopePackage; /**
 * AbstractRuler.java
 * This is an abstract class that defines useful attributes for use in the Ruler subclasses, as well as functions
 * @author William Hemminger
 * 30 April 2021
 */

import java.awt.*;

public abstract class AbstractRuler implements RulerIF{
    protected String title;
    protected int xStart, xEnd;
    protected int yStart, yEnd;
    protected Color color;
    protected String identifier;

    public AbstractRuler()
    {
        title = "NO TITLE";

        xStart = 0;
        xEnd = 0;
        yStart = 0;
        yEnd = 0;
        color = Color.WHITE;
        identifier= "NO IDENTIFIER";
    }

    public AbstractRuler(String title)
    {
        this.title = title;
    }

    //call from drawing function to actually plot the ruler
    public void plotRuler(WaveIF sourceWave)
    {

        if(sourceWave instanceof WaveDecorator)
        {
            return;
        }

        Graphics g = sourceWave.getWaveImage().getGraphics();
        g.setColor(color);

        this.calculateEndpoint(sourceWave);
        g.drawPolyline(new int[] {xStart, xEnd}, new int[] {yStart, yEnd}, 2);
        this.drawTitle(g);
    }

    public String getIdentifier()
    {
        return this.identifier;
    }

    protected abstract void drawTitle(Graphics g);
}
