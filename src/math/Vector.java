package math;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Vector {
    final double[] vector;

    /**
     * @param array | a double array which represents the values in the vector.
     * @throws IllegalArgumentException | array == null
     *
     */
    public Vector(double[] array){
        if(array==null){throw new IllegalArgumentException("Vector array cannot be null");}
        this.vector=array.clone();
    }

    /**
     * @param scalar | Scalar to multiply the matrix with
     * @return a new vector multiplied by the scalar
     *
     */
    public Vector multiply(double scalar){
        double[] array = new double[this.getLength()];
        IntStream.range(0,this.getLength()).forEach(i->array[i]= this.getIndex(i)*scalar);
        Vector multiplied = new Vector(array);
        return multiplied;
    }

    /**
     * @param b | the second vector in the dot product
     * @return a double representing the dot product
     * @throws IllegalArgumentException | b==null
     * @throws IllegalArgumentException | b.getLength() != this.getLength()
     */
    public double dotProduct(Vector b){
        if(this.getLength()!= b.getLength()){throw new IllegalArgumentException("Vectors must be the same length for dot Product");}
        double sum =0;
        for(int i=0;i<this.vector.length;i++){
            sum += this.vector[i]*b.getVectorArray()[i];
        }
        return sum;
    }

    /**
     * @return clone of the array representing the vector
     */
    public double[] getVectorArray(){
        return this.vector.clone();
    }
    /**
     * @return int representing length of the vector
     */
    public int getLength(){
        return this.vector.length;
    }

    /**
     * @param i | index of interest
     * @return double representing value of at given index
     */
    public double getIndex(int i){
        return this.vector[i];
    }

    /**
     * @param b | comparison vector object
     * @return boolean if the two are equal
     */
    public boolean equals(Vector b){
        return Arrays.equals(this.getVectorArray(),b.getVectorArray());
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
