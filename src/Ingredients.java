import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ingredients {
    private int mlOfWater;
    private int mlOfMilk;
    private int gOfCoffee;
    private int cups;
    private int money;
    private String username;
    private String password;
    private final String path = "doc/Ingredients.txt";

    public void updateIngredients(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))){
            writer.print(mlOfWater + "; " + mlOfMilk + "; " + gOfCoffee + "; " + cups +  "; " + money +"\nadmin; admin123" );
        }catch (Exception e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void getIngredients(){
        Scanner scanner;

        try (FileReader filereader = new FileReader(path)){
            scanner = new Scanner(filereader);

            scanner.useDelimiter("; |\n");

            mlOfWater = scanner.nextInt();
            mlOfMilk = scanner.nextInt();
            gOfCoffee = scanner.nextInt();
            cups = scanner.nextInt();
            money = scanner.nextInt();


            setUsername(scanner.next());
            setPassword(scanner.next());

        }catch (IOException e){
            System.out.println("File not found: " + e.getMessage());
        }

    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getgOfCoffee() {
        return gOfCoffee;
    }

    public void setgOfCoffee(int gOfCoffee) {
        this.gOfCoffee = gOfCoffee;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
