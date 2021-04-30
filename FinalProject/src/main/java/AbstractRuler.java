import java.awt.*;

public abstract class AbstractRuler implements RulerIF{
    protected String title;
    protected int xStart, xEnd;
    protected int yStart, yEnd;
    protected Color color;

    public AbstractRuler()
    {
        title = "NO TITLE";

        xStart = 0;
        xEnd = 0;
        yStart = 0;
        yEnd = 0;
        color = Color.WHITE;
    }

    public AbstractRuler(String title)
    {
        this.title = title;
    }

    //call from drawing function to actually plot the ruler
    public void plotRuler(WaveIF sourceWave)
    {
        System.out.println("HERE PLOT");

        if(sourceWave instanceof WaveDecorator)
        {
            System.out.println("WHY");
        }

        Graphics g = sourceWave.getWaveImage().getGraphics();
        g.setColor(color);

        this.calculateEndpoint(sourceWave);
        g.drawPolyline(new int[] {xStart, xEnd}, new int[] {yStart, yEnd}, 2);
        this.drawTitle(g);
    }

    protected abstract void drawTitle(Graphics g);
}
