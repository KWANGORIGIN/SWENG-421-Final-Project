package mainPackage;

/**
 * HorizontalRuler.java
 * This is an abstract class that defines useful features for Horizontal rulers
 * @author William Hemminger
 * 30 April 2021
 */

public abstract class HorizontalRuler extends AbstractRuler {
    public HorizontalRuler()
    {}

    public HorizontalRuler(int xStart, int yLevel)
    {
        this.xStart = xStart;
        this.yStart = this.yEnd = yLevel;
    }
}
