package mainPackage;

import java.util.ArrayList;

public class HorizArg extends WaveArg{
    public HorizArg(double value){
        super(value);
        this.type = "Horizontal Shift";

        //Logic for string representation
    }

    public WaveArgIF cloneArg(){
        WaveArg arg = new HorizArg(this.value);
        arg.changed = this.changed;
        arg.observers = (ArrayList<ObserverIF>) this.observers.clone();
        arg.shared = this.shared;
        arg.valueString = this.valueString;
        arg.type = this.type;
        return arg;
    }
}
