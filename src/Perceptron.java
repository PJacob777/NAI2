import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Perceptron {
    private double threshold;
    private Vector weight;

    public Perceptron(int n) {
        threshold = Math.random();
        weight = new Vector(n);
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
