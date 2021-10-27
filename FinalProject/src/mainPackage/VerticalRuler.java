package mainPackage;

/**
 * VerticalRuler.java
 * This is an abstract class that defines useful features for Vertical Rulers
 * @author William Hemminger
 * 30 April 2021
 */

public abstract class VerticalRuler extends AbstractRuler{
    public VerticalRuler()
    {}

    public VerticalRuler(int yStart, int xLevel)
    {
        this.yStart = yStart;
        this.xStart = this.xEnd = xLevel;
    }
}
