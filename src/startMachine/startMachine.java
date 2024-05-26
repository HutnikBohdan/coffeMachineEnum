package startMachine;



public class startMachine {
    private int wather;
    private int milk;
    private int coffeeBeanc;
    private int cups;
    private int money;
    public statMach status;

    public startMachine(int wather, int milk, int coffeeBeanc, int cups, int money) {
        this.wather = wather;
        this.milk = milk;
        this.coffeeBeanc = coffeeBeanc;
        this.cups = cups;
        this.money = money;
        actionMenu();
    }
    enum statMach {
        CHOOSING_ACTION, REMAINING, FILL,
        TAKE, EXIT, BUY
    }




    public void actionMenu() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        status = statMach.CHOOSING_ACTION;
    }


    public void machineON (String operation) {
        switch (status) {
            case BUY:
                buyMenu(operation);
                break;

        }
    }


    public void buyMenu(String operation) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        int num = 0;
        try {
            num = Integer.parseInt(operation);
            switch (num) {
                case 1:
                    buyEspresso();
                    break;
                case 2:
                    buyLatte();
                    break;
                case 3:
                    buyCappuccino();
            }
        } catch (Exception e) {
            if ("back".equals(operation)) {
                status = statMach.CHOOSING_ACTION;
                actionMenu();
            } else {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            }

        }

    }


    public void buyEspresso () {
        String error = "";
        if (this.wather >= 250 && this.coffeeBeanc >= 16 && this.money >= 4 && this.cups > 0) {
            this.wather -= 250;
            this.coffeeBeanc -= 16;
            this.cups -= 1;
            this.money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 250 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.coffeeBeanc - 12 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
        actionMenu();
    }

    public void buyLatte () {
        String error = "";
        if (this.wather >= 350 && this.milk >= 75 && this.coffeeBeanc >= 20 && this.money >= 7 && this.cups > 0) {
            this.wather -= 350;
            this.milk -= 75;
            this.coffeeBeanc -= 20;
            this.cups -= 1;
            this.money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 350 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.milk - 75 < 0 ? error += "Sorry, not enough milk!\n": error;
            error = this.coffeeBeanc - 20 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
        actionMenu();
    }

    public void buyCappuccino () {
        String error = "";
        if (this.wather >= 200 && this.milk >= 100 && this.coffeeBeanc >= 12 && this.money >= 6 && this.cups > 0) {
            this.wather -= 200;
            this.milk -= 100;
            this.coffeeBeanc -= 12;
            this.cups -= 1;
            this.money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            error = this.wather - 200 < 0 ? error += "Sorry, not enough water!\n": error;
            error = this.milk - 100 < 0 ? error += "Sorry, not enough milk!\n": error;
            error = this.coffeeBeanc - 12 < 0 ? error += "Sorry, not enough coffee beans!\n": error;
            error = this.cups - 1 < 0 ? error += "Sorry, not enough coffee cups!\n": error;
            System.out.println(error);
        }
        actionMenu();
    }

}
