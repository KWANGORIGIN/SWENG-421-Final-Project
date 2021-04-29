import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class WaveArg implements WaveArgIF {
    protected double value;
    protected String valueString = "hello";
    protected String type;//for setting the String key of Hashtables
    protected ArrayList<ObserverIF> observers;

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

    public void addObserver(ObserverIF o){
        observers.add(o);
    }

    public void removeObserver(ObserverIF o){
        observers.remove(o);
    }

    public void notifyObservers(String type){
        for(ObserverIF o : observers){
            o.update(type);
        }
    }

}
