import startMachine.startMachine;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        startMachine machine = new startMachine(400, 540, 120, 9, 550);

        String end = "";
        while (!"exit".equals(end)) {
            end = machine.machineON(input.next());
        }

    }
}


