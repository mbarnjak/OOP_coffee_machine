import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Logic {

    Ingredients ingredient = new Ingredients();


    String path = "doc/Ingredients.txt";



    public void updateIngredients(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))){
            writer.print(ingredient.getMlOfWater() + "; " + ingredient.getMlOfMilk() + "; " + ingredient.getgOfCoffee() + "; " + ingredient.getCups() +  "; " + ingredient.getMoney() +"\nadmin; admin123" );
        }catch (Exception e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public void getIngredients(){
        Scanner scanner;

        try (FileReader filereader = new FileReader(path)){
            scanner = new Scanner(filereader);

            scanner.useDelimiter("; |\n");

            ingredient.setMlOfWater(scanner.nextInt());
            ingredient.setMlOfMilk(scanner.nextInt());
            ingredient.setgOfCoffee(scanner.nextInt());
            ingredient.setCups(scanner.nextInt());
            ingredient.setMoney(scanner.nextInt());

            ingredient.setUsername(scanner.next());
            ingredient.setPassword(scanner.next());

        }catch (IOException e){
            System.out.println("File not found: " + e.getMessage());
        }

    }


    public void fillMachineWithIngredients(int waterToAdd, int milkToAdd, int coffeeToAdd, int cupsToAdd) {
        ingredient.setMlOfWater(ingredient.getMlOfWater() + waterToAdd);

        ingredient.setMlOfMilk(ingredient.getMlOfMilk() + milkToAdd);

        ingredient.setgOfCoffee(ingredient.getgOfCoffee() + coffeeToAdd);

        ingredient.setCups(ingredient.getCups() + cupsToAdd);
    }


    public void takeMoney() {
        System.out.println("I gave you $" + ingredient.getMoney() );
        ingredient.setMoney(0);

    }


    //espresso
    public boolean enoughResourcesEspresso() {
        if (ingredient.getMlOfWater() < 250) {
            return false;
        }
        else if (ingredient.getgOfCoffee() < 16) {
            return false;
        }
        else return ingredient.getCups() >= 1;
    }

    public void makeEspresso(){
        ingredient.setMlOfWater(ingredient.getMlOfWater() - 250);
        ingredient.setgOfCoffee(ingredient.getgOfCoffee() - 16);
        ingredient.setCups(ingredient.getCups() - 1);
        ingredient.setMoney(ingredient.getMoney() - 4);
    }


    //latte
    public boolean enoughResourcesLatte() {
        if (ingredient.getMlOfWater() < 350) {
            return false;
        }else if(ingredient.getMlOfMilk() < 75){
            return false;
        }
        else if (ingredient.getgOfCoffee() < 20) {
            return false;
        }
        else return ingredient.getCups() >= 1;
    }

    public void makeLatte(){
        ingredient.setMlOfWater(ingredient.getMlOfWater() - 350);
        ingredient.setMlOfMilk(ingredient.getMlOfMilk() - 75);
        ingredient.setgOfCoffee(ingredient.getgOfCoffee() - 20);
        ingredient.setCups(ingredient.getCups() - 1);
        ingredient.setMoney(ingredient.getMoney() - 7);
    }


    //cappuccino
    public boolean enoughResourcesCappuccino() {
        if (ingredient.getMlOfWater() < 200) {
            return false;
        }else if(ingredient.getMlOfMilk() < 100){
            return false;
        }
        else if (ingredient.getgOfCoffee() < 12) {
            return false;
        }
        else return ingredient.getCups() >= 1;
    }

    public void makeCappuccino(){
        ingredient.setMlOfWater(ingredient.getMlOfWater() - 200);
        ingredient.setMlOfMilk(ingredient.getMlOfMilk() - 100);
        ingredient.setgOfCoffee(ingredient.getgOfCoffee() - 12);
        ingredient.setCups(ingredient.getCups() - 1);
        ingredient.setMoney(ingredient.getMoney() - 6);
    }






}
