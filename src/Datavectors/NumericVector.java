package Datavectors;

public abstract class NumericVector extends Datavector {
    public NumericVector(String name) {
        super(name);
    }
    public abstract double mean();
    public abstract double sum();
}
