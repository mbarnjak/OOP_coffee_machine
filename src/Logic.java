import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Logic {
    int mlOfWater;
    int mlOfMilk;
    int gOfCoffee;
    int cups;
    int money;
    String username;
    String password;


    String path = "doc/Ingredients.txt";



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

            username = scanner.next();
            password = scanner.next();
            System.out.println(username);

        }catch (IOException e){
            System.out.println("File not found: " + e.getMessage());
        }

    }


    public void fillMachineWithIngredients(int waterToAdd, int milkToAdd, int coffeeToAdd, int cupsToAdd) {
        mlOfWater += waterToAdd;

        mlOfMilk += milkToAdd;

        gOfCoffee += coffeeToAdd;

        cups += cupsToAdd;
    }


    public void takeMoney() {
        System.out.println("I gave you $" + money );
        money = 0;

    }


    //espresso
    public boolean enoughResourcesEspresso() {
        if (mlOfWater < 250) {
            return false;
        }
        else if (gOfCoffee < 16) {
            return false;
        }
        else return cups >= 1;
    }

    public void makeEspresso(){
        mlOfWater -= 250;
        gOfCoffee -= 16;
        cups -= 1;
        money += 4;
    }


    //latte
    public boolean enoughResourcesLatte() {
        if (mlOfWater < 350) {
            return false;
        }else if(mlOfMilk < 75){
            return false;
        }
        else if (gOfCoffee < 20) {
            return false;
        }
        else return cups >= 1;
    }

    public void makeLatte(){
        mlOfWater -= 350;
        mlOfMilk -= 75;
        gOfCoffee -= 20;
        cups -= 1;
        money += 7;
    }


    //cappuccino
    public boolean enoughResourcesCappuccino() {
        if (mlOfWater < 200) {
            return false;
        }else if(mlOfMilk < 100){
            return false;
        }
        else if (gOfCoffee < 12) {
            return false;
        }
        else return cups >= 1;
    }

    public void makeCappuccino(){
        mlOfWater -= 200;
        mlOfMilk -= 100;
        gOfCoffee -= 12;
        cups -= 1;
        money += 6;
    }






}
