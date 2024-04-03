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
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] split = line.split(",");
                double[] digits = new double[weight.getParams().length];
                for (int i=0; i< digits.length;i++){
                    digits[i]=Double.parseDouble(split[i]);
                }
                double res =0;
                for(int i =0 ; i < weight.getParams().length;i++){
                    res+=digits[i]*weight.getParams()[i];
                }
                if(!split[split.length-1].equals(getNameOfFlower(res)))
                    correctPerceptron(getNameOfFlower(res));
                System.out.println(threshold);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void correctPerceptron(String name) {
        if (name.equals("Iris-setosa"))
            increaseVec();
        else
            decreaseVec();

    }

    private String getNameOfFlower(double result){
        return result>threshold?"Iris-setosa":"Iris-versicolor";
    }
    private void changeThreshold(double x){
        threshold-=x;
    }
    private void increaseVec(){
        for (int i=0;i<weight.getParams().length;i++)
            weight.getParams()[i]+=weight.getParams()[i]*con;
        changeThreshold(-con);

    }
    private void decreaseVec(){
        for (int i=0;i<weight.getParams().length;i++)
            weight.getParams()[i]-=weight.getParams()[i]*con;
        changeThreshold(con);
    }

    public void testPerceptron() {
    }
}
