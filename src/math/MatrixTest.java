package math;

import math.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void TwoByTwoDet(){
        Matrix testMatrix = new Matrix(new Vector[]{
                new Vector(new double[]{1,2}),
                new Vector(new double[]{3,4})
        });
        assertTrue(testMatrix.determinant()==-2);
    }
    @Test
    void ThreeByThreeMatrixDet(){
        Matrix testMatrix = new Matrix( new Vector[]{
                new Vector(new double[]{1,2,3}),
                new Vector(new double[]{3,2,1}),
                new Vector(new double[]{1,3,2})
        });
        assertTrue(testMatrix.determinant()==12);
    }
    @Test
    void MatrixMultiplication(){
        Matrix a = new Matrix( new Vector[]{
                new Vector(new double[]{1,2,3}),
                new Vector(new double[]{4,5,6})
        });
        Matrix b = new Matrix(new Vector[]{
                new Vector(new double[]{7,8}),
                new Vector(new double[]{9,10}),
                new Vector(new double[]{11,12}),
                new Vector(new double[]{13,14})
        });
        Matrix finalMatrix = new Matrix(new Vector[]{
                new Vector(new double[]{39,54,69}),
                new Vector(new double[]{49,68,87}),
                new Vector(new double[]{59,82,105}),
                new Vector(new double[]{69,96,123})});
        System.out.println(finalMatrix);
        System.out.println(a.multiply(b));
        System.out.println(finalMatrix.transpose());
        assertTrue(finalMatrix.equals(a.multiply(b)));
    }
}