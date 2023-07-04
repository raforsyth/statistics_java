package Datavectors;

import java.util.stream.IntStream;

public abstract class Datavector {
    private String name;
    protected Object[] vector;
    public Datavector(String name){
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
