package Elevator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Elevator {
    private final int waitDoorsInSeconds = 10;
    private final int waitMoveInSeconds = 5;
    private final Deque<Integer> queue = new ArrayDeque<>();
    private int totalSeconds;
    private int previousFloor;
    private int currentFloor;

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setPreviousFloor(int previousFloor) {
        this.previousFloor = previousFloor;
    }

    public int calculateMovingTime() {
        if (previousFloor != 0) {
            totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
            totalSeconds += waitDoorsInSeconds;
        }
        return totalSeconds;
    }

    public String showQueue() {
        StringBuilder sb = new StringBuilder();
        sb.append("Лифт проследовал по следующим этажам:");

        while (!queue.isEmpty()) {
            sb.append(" этаж " + queue.poll());
        }
        sb.append("\nВремя затраченное лифтом на маршрут - " + totalSeconds + " с.");
        return String.valueOf(sb);
    }

    public boolean move(int floor) {
        if (floor == 0) {
            System.out.println(showQueue());
            return false;
        }
        if (floor < 0 || floor > 25) {
            System.out.println("Такого этажа нет в доме");
            return false;
        } else {
            if (!queue.isEmpty()) {
                setPreviousFloor(queue.peekLast());
            }
            queue.offer(floor);
            setCurrentFloor(queue.peekLast());
            calculateMovingTime();
        }
        return true;
    }

}
