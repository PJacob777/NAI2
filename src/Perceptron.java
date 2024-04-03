import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Perceptron {
    private double threshold;
    private Vector weight;
    private final double con;
    private final String trainPath;
    private final String testPath;

    public Perceptron(int n,double con,String trainPath, String testPath) {
        threshold = Math.random();
        weight = new Vector(n);
        this.con=con;
        this.trainPath=trainPath;
        this.testPath=testPath;
        double[] tmp = weight.getParams();
        for (int i = 0;i <tmp.length;i++){
            tmp[i] = Math.random();
        }
    }
    public void learnPerceptron(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(trainPath))){

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
