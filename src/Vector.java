import java.util.Arrays;

public class Vector {
    private double[] params;
    public Vector(int n){
        params = new double[n];
    }

    public double[] getParams() {
        return params;
    }

    public void setParams(double[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "params=" + Arrays.toString(params) +
                '}';
    }
}
