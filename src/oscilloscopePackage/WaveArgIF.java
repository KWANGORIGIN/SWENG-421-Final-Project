package oscilloscopePackage;

public interface WaveArgIF extends ObservableIF, Cloneable{
    String getType();
    double getValue();
    boolean isShared();
    void setShared();
    void clearShared();
    String toString();
    WaveArgIF cloneArg();
}
