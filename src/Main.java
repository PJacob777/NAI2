import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        Database database = new Database("train-set.csv", "test-set.csv", 0.5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czu chcesz testowac z pliku testowego? T czy N ");
        String answer = scanner.nextLine();
        if (answer.equals("T"))
            database.testPerceptron();
        else {
            do {
                System.out.println("Podaj wektor " + database.getNumberOfDigitsInVector() + " wymiarowy. Oddzielony przecinkami");
                answer = scanner.next();
                double[] doubles = new double[database.getNumberOfDigitsInVector()];
                int a = 0;
                for (String i : answer.split(","))
                    doubles[a++] = Double.parseDouble(i);
                database.giveNameOfFlower(doubles);
                System.out.println("Czy chcesz kontynouwac? T czy N ?");
                answer = scanner.next().charAt(0)+ "";
            }while (!answer.equals("N"));
        }
    }
}