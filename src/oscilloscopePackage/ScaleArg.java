package oscilloscopePackage;

import java.util.ArrayList;

public class ScaleArg extends WaveArg{
    public ScaleArg(double value){
        super(value);
        this.type = "Scale";

        //Logic for string representation
    }

    public WaveArgIF cloneArg(){
        WaveArg arg = new ScaleArg(this.value);
        arg.changed = this.changed;
        arg.observers = (ArrayList<ObserverIF>) this.observers.clone();
        arg.shared = this.shared;
        arg.valueString = this.valueString;
        arg.type = this.type;
        return arg;
    }
}
