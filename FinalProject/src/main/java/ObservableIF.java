public interface ObservableIF {
    void addObserver(ObserverIF o);
    void removeObserver(ObserverIF o);
    void notifyObservers(String type);
}
