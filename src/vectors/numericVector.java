package vectors;

public abstract class numericVector extends datavector{
    public numericVector(String name) {
        super(name);
    }
    public abstract double mean();
    public abstract double sum();
}
