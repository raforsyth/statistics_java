package vectors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class categoricalVector extends datavector {
    private String[] categoricalVector;
    public categoricalVector(String name) {
        super(name);
    }
    public categoricalVector(String name, String[] vector){
        super(name);
        this.categoricalVector=vector.clone();
        IntStream.range(0,vector.length).forEach(i->this.vector[i]=vector[i]);
    }
}
