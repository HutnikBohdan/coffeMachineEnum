package startMachine;



public class startMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    private boolean fillWater;
    private boolean fillMilk;
    private boolean fillCoffeeB;
    private boolean fillCups;

    statMach status;


    public startMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
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


    public String machineON (String operation) {
        switch (status) {
            case CHOOSING_ACTION:
                actionMenuOperation(operation);
                break;
            case BUY:
                buyMenu(operation);
                break;
            case FILL:
                fill(operation);
                break;
            case TAKE:
                take();
                break;
            case REMAINING:
                remaining();
                break;
            case EXIT:
                operation = "exit";

        }
        return operation;
    }

    public void actionMenuOperation(String action) {
        if ("buy".equals(action) || "fill".equals(action) || "take".equals(action) || "remaining".equals(action) || "exit".equals(action)) {
            switch (action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    status = statMach.BUY;
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    status = statMach.FILL;
                    setFill();
                    break;
                case "take":
                    status = statMach.TAKE;
                    break;
                case "remaining":
                    status = statMach.REMAINING;
                    break;
                case "exit":
                    status = statMach.EXIT;
                    break;

            }
            machineON(action);
        } else {
            actionMenu();
        }
    }

    public void buyMenu(String operation) {
        if ("1".equals(operation) || "2".equals(operation) || "3".equals(operation) || "back".equals(operation)) {
            switch (operation) {
                case "1":
                    buyEspresso();
                    break;
                case "2":
                    buyLatte();
                    break;
                case "3":
                    buyCappuccino();
                    break;
                case "back":
                    actionMenu();
            }
        }

    }


    public boolean numOrNot(String value) {
        boolean number = true;
        try {
            int num = Integer.parseInt(value);
        } catch (Exception e) {
            number = false;
        }
        return number;
    }

    public void setFill() {
        this.fillWater = true;
        this.fillMilk = true;
        this.fillCoffeeB = true;
        this.fillCups = true;
    }

    public void fill(String value) {
        if (numOrNot(value)) {
            if (fillWater) {
                this.water += Integer.parseInt(value);
                System.out.println("Write how many ml of milk you want to add: ");
                fillWater = false;
            } else if (fillMilk) {
                this.milk += Integer.parseInt(value);
                System.out.println("Write how many grams of coffee beans you want ");
                fillMilk = false;
            } else if (fillCoffeeB) {
                this.coffeeBeans += Integer.parseInt(value);
                System.out.println("Write how many disposable cups you want to add:");
                fillCoffeeB = false;
            } else if (fillCups) {
                this.cups += Integer.parseInt(value);
                fillCups = false;
                setFill();
                actionMenu();
            }

        }
    }


    public void buyEspresso () {
        int[] espresso = {250, 16, 1, 4};
        if (this.water >= 250 && this.coffeeBeans >= 16 && this.money >= 4 && this.cups > 0) {
            buyCaffe(espresso);
        } else {
            buyPrintError(espresso);
        }
        actionMenu();
    }

    public void buyLatte () {
        int[] latte = {350, 20, 1, 7, 75};
        if (this.water >= 350 && this.milk >= 75 && this.coffeeBeans >= 20 && this.money >= 7 && this.cups > 0) {
            buyCaffe(latte);
        } else {
            buyPrintError(latte);
        }
        actionMenu();
    }

    public void buyCappuccino () {
        int[] cappuccino = {200, 12, 1, 6, 100};
        if (this.water >= 200 && this.milk >= 100 && this.coffeeBeans >= 12 && this.money >= 6 && this.cups > 0) {
            buyCaffe(cappuccino);
        } else {
            buyPrintError(cappuccino);
        }
        actionMenu();
    }


    public void buyCaffe(int[] args) {
        this.water -= args[0];
        this.coffeeBeans -= args[1];
        this.cups -= args[2];
        this.money += args[3];
        if (args.length == 5) {
            this.milk -= args[4];
        }

        System.out.println("I have enough resources, making you a coffee!");
    }

    public void buyPrintError(int[] args) {
        String error = "";
        error = this.water - args[0] < 0 ? error += "Sorry, not enough water!\n": error;
        if (args.length == 5) {
            error = this.milk - args[4] < 0 ? error += "Sorry, not enough milk!\n": error;
        }
        error = this.coffeeBeans - args[1] < 0 ? error += "Sorry, not enough coffee beans!\n": error;
        error = this.cups - args[2] < 0 ? error += "Sorry, not enough coffee cups!\n": error;
        System.out.println(error);
    }


    public void take() {
        System.out.printf("\nI gave you $%d\n", this.money);
        this.money = 0;
        actionMenu();
    }

    public void remaining () {
        System.out.printf("\nThe coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n" +
                "%d disposable cups\n$%d of money\n",this.water, this.milk, this.coffeeBeans, this.cups, this.money);
        status = statMach.CHOOSING_ACTION;
        actionMenu();
    }

}
