import java.awt.*;

public abstract class HorizontalRuler extends AbstractRuler {
    public HorizontalRuler()
    {}

    public HorizontalRuler(int xStart, int yLevel)
    {
        this.xStart = xStart;
        this.yStart = this.yEnd = yLevel;
    }

//    protected void drawTitle(Graphics g)
//    {
//        System.out.println("drawing title");
//        g.setFont(new Font("Courier", Font.PLAIN, 12));
//        g.drawString(this.title, 5, 15);
//    }
}
