package mainPackage;

/**
 * RulerIF.java
 * This interface declares the necessary functions used with the Ruler family of objects
 * @author William Hemminger
 * 30 April 2021
 */

public interface RulerIF {
    void calculateEndpoint(WaveIF sourceWave);
    void plotRuler(WaveIF sourceWave);
    String getIdentifier();
}
