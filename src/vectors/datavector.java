package vectors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public abstract class datavector {
    private String name;
    protected Object[] vector;
    public datavector(String name){
        this.name = name;
    }
    public int length(){
        return this.vector.length;
    }
    public void extend(){
        Object[] longerVector = new Object[this.vector.length*2];
        IntStream.range(0,this.vector.length).forEach(i-> longerVector[i] = vector[i]);
        this.vector=longerVector;
    }
}
