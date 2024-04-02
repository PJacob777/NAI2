import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
    public Database(String path) {
        System.out.println(numberOfDigitsInVector(path));
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
}
