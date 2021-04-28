import java.text.DecimalFormat;

public abstract class WaveArg implements WaveArgIF {
    protected double value;
    protected String valueString = "hello";
    protected String type;//for setting the String key of Hashtables

    public String getType(){
        return this.type;
    }

    public double getValue(){
        return this.value;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(this.getValue());
    }

}
