package Datavectors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DoubleVector extends NumericVector {
    public DoubleVector(String name) {
        super(name);
    }
    /**
     * @param name
     * @param vector
     * @throws IllegalArgumentException | vector == null
     */
    public DoubleVector(String name, double[] vector){
        super(name);
        if(vector == null){throw new IllegalArgumentException();}
        //this.numericVector=vector.clone();
        this.vector = new Object[vector.length];
        IntStream.range(0,vector.length).forEach(i->this.vector[i]=vector[i]);
    }
    public double mean(){
        double sum = 0;
        for(Object data: this.vector){
            sum+=(double) data;
        }
        return (sum/this.vector.length);
    }
    public double sum(){
        double sum = 0;
        for(Object data: this.vector){
            sum+=(double) data;
        }
        return sum;
    }
    public void add(double data){
        if(Arrays.stream(this.vector).allMatch(i->i!=null)){extend();}
        for(Object dataPoint : this.vector){
            if(dataPoint ==null){dataPoint = data; break;}
        }
    }
    public void append(double[] dataArray){
        for(double data: dataArray){this.add(data);}
    }
    
}
