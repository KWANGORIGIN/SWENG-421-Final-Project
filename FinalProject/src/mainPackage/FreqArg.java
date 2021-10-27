package mainPackage;

import java.util.ArrayList;

public class FreqArg extends WaveArg{
    public FreqArg(double value){
        super(value);
        this.type = "Frequency";

        //Logic for string representation
    }

    public WaveArgIF cloneArg(){
        WaveArg arg = new FreqArg(this.value);
        arg.changed = this.changed;
        arg.observers = (ArrayList<ObserverIF>) this.observers.clone();
        arg.shared = this.shared;
        arg.valueString = this.valueString;
        arg.type = this.type;
        return arg;
    }
}
