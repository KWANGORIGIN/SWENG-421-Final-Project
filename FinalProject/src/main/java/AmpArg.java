import java.text.DecimalFormat;
import java.util.ArrayList;

public class AmpArg extends WaveArg{
    public AmpArg(double value){
        super(value);
        this.type = "Amplitude";
        //Logic for string representation
    }

    public WaveArgIF cloneArg(){
        WaveArg arg = new AmpArg(this.value);
        arg.changed = this.changed;
        arg.observers = (ArrayList<ObserverIF>) this.observers.clone();
        arg.shared = this.shared;
        arg.valueString = this.valueString;
        arg.type = this.type;
        return arg;
    }
}
