package mainPackage;

import java.util.ArrayList;

public class VertArg extends WaveArg{
    public VertArg(double value){
        super(value);
        this.type = "Vertical Shift";

        //Logic for string representation
    }
    public WaveArgIF cloneArg(){
        WaveArg arg = new VertArg(this.value);
        arg.changed = this.changed;
        arg.observers = (ArrayList<ObserverIF>) this.observers.clone();
        arg.shared = this.shared;
        arg.valueString = this.valueString;
        arg.type = this.type;
        return arg;
    }
}
