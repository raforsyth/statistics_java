package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.pow;

public class Matrix {
    final Vector[] matrix;
    public Matrix(Vector[] matrix){
        this.matrix=matrix;
    }
    public Matrix transpose(){
        Vector[] transposeArray = new Vector[this.getHeight()];
        for(int row =0; row<this.getHeight();row++){
            double[] array = new double[this.getWidth()];
            for(int col =0; col<this.getWidth();col++){
                array[col] = this.getIndex(row,col);
            }
            transposeArray[row] = new Vector(array);
        }
        return new Matrix(transposeArray);
    }
    public double determinant(){
        ArrayList<Matrix> neededDets = new ArrayList<Matrix>();
        double sum = 0;
        if(matrix.length == 2){
            return (matrix[0].getIndex(0)*matrix[1].getIndex(1))-(matrix[0].getIndex(1)*matrix[1].getIndex(0));
        }
        for(int i=0; i<matrix.length;i++){
            //neededDets.add(i,new Matrix(matrix.length-1,matrix.length-1));
            Vector[] newArray = new Vector[matrix.length-1];
            for(int col=1; col< (matrix.length);col++){
                ArrayList<Double> columnVector = new ArrayList<Double>();
                for(int row =0; row<(matrix.length);row++){
                    if(row != i){
                        columnVector.add(matrix[col].getIndex(row));
                    }
                }
                //neededDets.get(i).fillColumn((col-1), Stream.of(columnVector.toArray(new Double[0])).mapToDouble(Double::doubleValue).toArray());
                newArray[col-1] = new Vector(Stream.of(columnVector.toArray(new Double[0])).mapToDouble(Double::doubleValue).toArray());
            }
            neededDets.add(i,new Matrix(newArray));
            sum+= pow(-1,(2+i))*matrix[0].getIndex(i)*neededDets.get(i).determinant();
        }
        return sum;
    }
    public Matrix multiply(Matrix b){
        Vector[] multipliedArray = new Vector[b.getWidth()];
        for(int i=0;i<b.getWidth();i++){
            double[] multipliedVector = new double[this.getHeight()];
            for(int x=0;x<this.getHeight();x++){
                double[] rowValues = new double[this.getWidth()];
                int finalx = x;
                IntStream.range(0,this.getWidth()).forEach(j-> rowValues[j]=this.matrix[j].getIndex(finalx));
                Vector rowVector = new Vector(rowValues);
                multipliedVector[x] = rowVector.dotProduct(b.getMatrix()[i]);
            }
            multipliedArray[i] = new Vector(multipliedVector);
        }
        return new Matrix(multipliedArray);
    }
    public Matrix multiply(double scalar){
        Vector[] multiplied = new Vector[this.getWidth()];
        for(int i=0;i<this.getWidth();i++){
            multiplied[i] = this.matrix[i].multiply(scalar);
        }
        return new Matrix(multiplied);
    }
    /*
    TODO: fix the rep leakage here
     */
    public Vector[] getMatrix(){
        return this.matrix.clone();
    }
    public int getWidth(){
        return this.matrix.length;
    }
    public int getHeight(){
        return this.matrix[0].getLength();
    }
    public double getIndex(int height,int width){
        return this.matrix[width].getIndex(height);
    }
    @Override
    public String toString(){
        String returnString = new String();
        for(int row = 0; row<matrix[0].getLength();row++){
            for(int col = 0; col<matrix.length;col++){
                returnString+=matrix[col].getIndex(row)+" ";
            }
            returnString += "\n";
        }
        return returnString;
    }
    public boolean equals(Matrix b){
        for(int i =0; i<this.getWidth();i++){
            if(!(this.matrix[i].equals(b.getMatrix()[i]))){
                return false;
            }
        }
        return true;
    }
}