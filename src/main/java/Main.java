import Elevator.Elevator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator();
        int floor = 1;

        while (floor != 0) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            floor = Integer.parseInt(scanner.nextLine());
            elevator.move(floor);
        }
    }

}
