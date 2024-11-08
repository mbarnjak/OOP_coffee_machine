

public class Logic {

    Data data = new Data();

    public void fillMachineWithIngredients(int waterToAdd, int milkToAdd, int coffeeToAdd, int cupsToAdd) {
        data.setMlOfWater(data.getMlOfWater() + waterToAdd);

        data.setMlOfMilk(data.getMlOfMilk() + milkToAdd);

        data.setgOfCoffee(data.getgOfCoffee() + coffeeToAdd);

        data.setCups(data.getCups() + cupsToAdd);
    }

    public void takeMoney() {
        System.out.println("I gave you $" + data.getMoney() );
        data.setMoney(0);

    }


    //espresso
    public boolean enoughResourcesEspresso() {
        if (data.getMlOfWater() < 250) {
            return false;
        }
        else if (data.getgOfCoffee() < 16) {
            return false;
        }
        else return data.getCups() >= 1;
    }

    public void makeEspresso(){
        data.setMlOfWater(data.getMlOfWater() - 250);
        data.setgOfCoffee(data.getgOfCoffee() - 16);
        data.setCups(data.getCups() - 1);
        data.setMoney(data.getMoney() + 4);
    }


    //latte
    public boolean enoughResourcesLatte() {
        if (data.getMlOfWater() < 350) {
            return false;
        }else if(data.getMlOfMilk() < 75){
            return false;
        }
        else if (data.getgOfCoffee() < 20) {
            return false;
        }
        else return data.getCups() >= 1;
    }

    public void makeLatte(){
        data.setMlOfWater(data.getMlOfWater() - 350);
        data.setMlOfMilk(data.getMlOfMilk() - 75);
        data.setgOfCoffee(data.getgOfCoffee() - 20);
        data.setCups(data.getCups() - 1);
        data.setMoney(data.getMoney() + 7);
    }


    //cappuccino
    public boolean enoughResourcesCappuccino() {
        if (data.getMlOfWater() < 200) {
            return false;
        }else if(data.getMlOfMilk() < 100){
            return false;
        }
        else if (data.getgOfCoffee() < 12) {
            return false;
        }
        else return data.getCups() >= 1;
    }

    public void makeCappuccino(){
        data.setMlOfWater(data.getMlOfWater() - 200);
        data.setMlOfMilk(data.getMlOfMilk() - 100);
        data.setgOfCoffee(data.getgOfCoffee() - 12);
        data.setCups(data.getCups() - 1);
        data.setMoney(data.getMoney() + 6);
    }


    //methods to send data from Data to UI
    public void loadFromFileData() {
        data.getIngredients();
    }

    public void saveDataToFile(){
        data.updateIngredients();
    }

    public String getUsername(){
        return data.getUsername();
    }

    public String getUserPass(){
        return data.getPassword();
    }

    public int getWater(){
        return data.getMlOfWater();
    }

    public int getBeans(){
        return data.getgOfCoffee();
    }

    public int getCups(){
        return data.getCups();
    }

    public int getMoney(){
        return data.getMoney();
    }

    public int getMilk(){
        return data.getMlOfMilk();
    }
}
