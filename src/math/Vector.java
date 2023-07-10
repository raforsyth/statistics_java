package math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Vector {
    final double[] vector;

    public Vector(double[] array){
        this.vector=array.clone();
    }
    public Vector multiply(double scalar){
        double[] array = new double[this.getLength()];
        IntStream.range(0,this.getLength()).forEach(i->array[i]= this.getIndex(i)*scalar);
        Vector multiplied = new Vector(array);
        return multiplied;
    }
    public double dotProduct(Vector b){
        double sum =0;
        for(int i=0;i<this.vector.length;i++){
            sum += this.vector[i]*b.getVector()[i];
        }
        return sum;
    }
    public double[] getVector(){
        return this.vector.clone();
    }
    public int getLength(){
        return this.vector.length;
    }
    public double getIndex(int i){
        return this.vector[i];
    }
    public boolean equals(Vector b){
        return Arrays.equals(this.getVector(),b.getVector());
    }
    @Override
    public String toString(){
        String returnString = new String();
        for(double data : this.vector){
            returnString+=data;
            returnString+="\n";
        }
        return returnString;
    }
}
