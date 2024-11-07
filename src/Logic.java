

public class Logic {

    Data ingredient = new Data();

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
        ingredient.setMoney(ingredient.getMoney() + 4);
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
        ingredient.setMoney(ingredient.getMoney() + 7);
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
        ingredient.setMoney(ingredient.getMoney() + 6);
    }


    public void loadFromFileData() {
        ingredient.getIngredients();
    }

    public void saveDataToFile(){
        ingredient.updateIngredients();
    }

    public String getUsername(){
        return ingredient.getUsername();
    }

    public String getUserPass(){
        return ingredient.getPassword();
    }

    public int getWater(){
        return ingredient.getMlOfWater();
    }

    public int getBeans(){
        return ingredient.getgOfCoffee();
    }

    public int getCups(){
        return ingredient.getCups();
    }

    public int getMoney(){
        return ingredient.getMoney();
    }

    public int getMilk(){
        return ingredient.getMlOfMilk();
    }
}
