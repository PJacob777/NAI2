import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Perceptron {
    private double threshold;
    private Vector weight;
    private final double con;

    public Perceptron(int n,double con) {
        threshold = Math.random();
        weight = new Vector(n);
        this.con=con;
        double[] tmp = weight.getParams();
        for (int i = 0;i <tmp.length;i++){
            tmp[i] = Math.random();
        }
    }
    public void learnPerceptron(String path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
