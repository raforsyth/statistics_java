package Datavectors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CategoricalVector extends Datavector {
    private String[] categoricalVector;
    public CategoricalVector(String name) {
        super(name);
    }
    public CategoricalVector(String name, String[] vector){
        super(name);
        this.categoricalVector=vector.clone();
        IntStream.range(0,vector.length).forEach(i->this.vector[i]=vector[i]);
    }
    public void add(String data){
        if(Arrays.stream(this.vector).allMatch(i->i!=null)){extend();}
        for(Object dataPoint : this.vector){
            if(dataPoint ==null){dataPoint = data; break;}
        }
    }
    public void append(String[] dataArray) {
        for (String data : dataArray) {
            this.add(data);
        }
    }
}
