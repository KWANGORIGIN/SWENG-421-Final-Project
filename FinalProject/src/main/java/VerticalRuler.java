import java.awt.*;

public abstract class VerticalRuler extends AbstractRuler{
    public VerticalRuler()
    {}

    public VerticalRuler(int yStart, int xLevel)
    {
        this.yStart = yStart;
        this.xStart = this.xEnd = xLevel;
    }

    
//    protected void drawTitle(Graphics g)
//    {
//        g.setFont(new Font("Courier", Font.PLAIN, 12));
//        g.drawString(this.title, this.xStart + 2, ((this.yEnd - this.yStart) / 2));
//    }
}
