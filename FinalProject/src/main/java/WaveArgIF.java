import java.util.ArrayList;
import java.util.Observer;

public interface WaveArgIF extends ObservableIF{
    String getType();
    double getValue();
    boolean isShared();
    void setShared();
    void clearShared();
//    String toString();
}
