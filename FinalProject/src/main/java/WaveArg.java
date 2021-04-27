public abstract class WaveArg implements WaveArgIF {
    protected double value;
    protected String valueString;
    protected String type;//for setting the String key of Hashtables

    public String getType(){
        return this.type;
    }

    public double getValue(){
        return this.value;
    }

    public String toString(){
        return this.valueString;
    }

}
