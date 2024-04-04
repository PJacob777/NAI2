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
                    correctPerceptron(getNameOfFlower(res),digits);
                //System.out.println(weight);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void correctPerceptron(String name,double[] doubles) {
        if (name.equals("Iris-setosa"))
            increaseVec(doubles);
        else
            decreaseVec(doubles);
//        System.out.println(weight);
//        System.out.println(threshold);
    }

    private String getNameOfFlower(double result){
        return result>threshold?"Iris-setosa":"Iris-versicolor";
    }
    private void changeThreshold(double x){
        threshold-=x;
    }
    private void increaseVec(double[] doubles){
        for (int i=0;i<weight.getParams().length;i++)
            weight.getParams()[i]+=weight.getParams()[i]*con*doubles[i];
        changeThreshold(-con);

    }
    private void decreaseVec(double[] doubles){
        for (int i=0;i<weight.getParams().length;i++)
            weight.getParams()[i]-=weight.getParams()[i]*con*doubles[i];
        changeThreshold(con);
    }

    public void testPerceptron() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(testPath))){
            String line;
            int counter=0;
            int correct =0;
            while ((line=bufferedReader.readLine())!=null){
                String[] split = line.split(",");
                double res =0;
                for (int i =0 ; i<weight.getParams().length;i++){
                    res+=Double.parseDouble(split[i])*weight.getParams()[i];
                }
                if(split[split.length-1].equals(getNameOfFlower(res)))
                    correct++;
                counter++;
            }
            double result = (double) correct /counter;
            System.out.println(result);

        }catch (IOException x){
            x.printStackTrace();
        }
    }
}
