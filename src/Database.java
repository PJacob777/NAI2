import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
    private final int numberOfDigitsInVector;
    public Database(String trainPath, String testPath,double con) {
        int n =  numberOfDigitsInVector(trainPath);
        numberOfDigitsInVector=n;
        Perceptron p = new Perceptron(n,con,trainPath,testPath);
        p.learnPerceptron();
        p.testPerceptron();
    }
    private int numberOfDigitsInVector(String path){
        int number=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String[] split = bufferedReader.readLine().split(",");
            try{
                for(String i: split) {
                    Double.parseDouble(i);
                    number++;
                }
            }catch (NumberFormatException exception){
                return number;
            }
        }catch (IOException x){
            x.printStackTrace();
        }

        return number;
    }

    public int getNumberOfDigitsInVector() {
        return numberOfDigitsInVector;
    }
}
