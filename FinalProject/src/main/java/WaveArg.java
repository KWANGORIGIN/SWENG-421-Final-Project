import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class WaveArg implements WaveArgIF {
    protected double value;
    protected String valueString = "hello";
    protected String type;//for setting the String key of Hashtables
    protected ArrayList<ObserverIF> observers;
    protected boolean changed;
    protected boolean shared;

    public WaveArg(double value){
        observers = new ArrayList<>();
        this.value = value;
        this.changed = false;
        this.shared = false;
    }

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

    @Override
    public void setObservers(ArrayList<ObserverIF> observers){
        this.observers = observers;
    }

    @Override
    public ArrayList<ObserverIF> getObservers(){
        return this.observers;
    }

    @Override
    public boolean hasChanged(){
        return this.changed;
    }

    @Override
    public void setChanged(){
        this.changed = true;
    }

    @Override
    public void setShared(){
        this.shared = true;
    }

    @Override
    public boolean isShared(){
        return this.shared;
    }

    @Override
    public void clearShared(){
        this.shared = false;
    }

    @Override
    public void clearChanged(){
        this.changed = false;
    }

    public void notifyObservers(WaveArgIF argChanged){
        for(ObserverIF o : observers){
            System.out.println("Notifying observer...");
            o.update(argChanged);
        }
        clearChanged();
    }

}
