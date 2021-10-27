package mainPackage;

import java.util.ArrayList;

public interface ObservableIF{
    void addObserver(ObserverIF o);
    void removeObserver(ObserverIF o);
    void setObservers(ArrayList<ObserverIF> observers);
    ArrayList<ObserverIF> getObservers();
    void notifyObservers(WaveArgIF argChanged);
    void setChanged();
    void clearChanged();
    boolean hasChanged();
}
