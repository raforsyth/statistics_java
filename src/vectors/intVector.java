package vectors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class intVector extends numericVector{

    public intVector(String name) {
        super(name);
    }
    public intVector(String name, int[] vector){
        super(name);
        IntStream.range(0,vector.length).forEach(i->this.vector[i]=vector[i]);
    }
    @Override
    public double mean(){
        //return Arrays.stream(this.numericVector).sum()/this.numericVector.length;
        double sum = 0;
        for(Object data: this.vector){
            sum+=(double) data;
        }
        return (sum/this.vector.length);
    }
    @Override
    public double sum(){
        //return Arrays.stream(this.numericVector).sum();
        double sum = 0;
        for(Object data: this.vector){
            sum+=(double) data;
        }
        return sum;
    }
    public void add(int data){
        if(Arrays.stream(this.vector).allMatch(i->i!=null)){extend();}
        for(Object dataPoint : this.vector){
            if(dataPoint ==null){dataPoint = data; break;}
        }
    }
}
