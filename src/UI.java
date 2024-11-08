import java.util.Scanner;

public class UI {

    Scanner scanner = new Scanner(System.in);

    Logic logic = new Logic();

    //main method
    public void startMachine() {
        logic.loadFromFileData();

        while (true) {
            System.out.println("1- buy\n2- login");
            System.out.print(">");

            int choice = inputInt();


            //buy
            if (choice == 1) {
                chooseCoffee();
            } else if (choice == 2) {
                System.out.println("Enter username:");
                System.out.print(">");
                String userNameInput = scanner.next();
                System.out.println("Enter password:");
                System.out.print(">");
                String passwordInput = scanner.next();
                if (userNameInput.equals(logic.getUsername()) && passwordInput.equals(logic.getUserPass())) {
                    while (true) {
                        printMainMenu();
                        choice = inputInt();
                        if (choice == 1) {
                            System.out.println("How many ml of water you want to add:");
                            int water = inputInt();

                            System.out.println("How many ml of milk you want to add:");
                            int milkToAdd = inputInt();

                            System.out.println("How many coffee you want to add?");
                            int coffee = inputInt();

                            System.out.println("How many cups you want to add?");
                            int cupsToAdd = inputInt();

                            logic.fillMachineWithIngredients(water, milkToAdd, coffee, cupsToAdd);

                            //take
                        } else if (choice == 2) {
                            logic.takeMoney();

                            //remaining
                        } else if (choice == 3) {
                            printIngredients();
                        }

                        //exit
                        else if (choice == 4) {
                            System.out.println("Turning off...");
                            logic.saveDataToFile();
                            System.exit(0);
                        } else if (choice == 5) {
                            break;
                        }
                    }
                }else System.out.println("Wrong username or password");
                //wrong input
            } else System.out.println(" ");

        }
    }


    private void chooseCoffee() {

        printCoffeeMenu();


        int choice = inputInt();

        if (choice == 1) {
            if (logic.enoughResourcesEspresso()) {
                logic.makeEspresso();
                System.out.println("I have enough resources, making you a espresso!");
            } else printNotEnoughResources();
        } else if (choice == 2) {
            if (logic.enoughResourcesLatte()) {
                logic.makeLatte();
                System.out.println("I have enough resources, making you a latte!");
            } else printNotEnoughResources();
        } else if (choice == 3) {
            if (logic.enoughResourcesCappuccino()) {
                logic.makeCappuccino();
                System.out.println("I have enough resources, making you a Cappuccino!");
            } else printNotEnoughResources();
        } else if (choice == 4) {
            System.out.println(" ");
        } else {
            System.out.println(" ");
        }

    }


    private void printIngredients() {
        System.out.println("The coffee machine has: \n" + logic.getWater() + " ml of water\n" + logic.getMilk() + " ml of milk\n" + logic.getBeans() +
                " g of coffee beans\n" + logic.getCups() + " disposable cups\n" + "$" + logic.getMoney() + " of money");
    }


    private void printNotEnoughResources() {
        System.out.println("Not enough resources.");
    }


    private void printMainMenu() {
        System.out.println("Write action(1 - fill, 2 - take, 3 - remaining, 4 - turn off, 5 - exit):");
        System.out.print(">");
    }


    private void printCoffeeMenu() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - main menu:");
        System.out.print(">");
    }


    private int inputInt() {
        if (scanner.hasNextInt())
            return scanner.nextInt();
        else {
            scanner.next();
            System.out.println("Wrong input");
            return 0;
        }
    }


}
