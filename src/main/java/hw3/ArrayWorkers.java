package hw3;
/*
Данный класс ArrayWorkers предназначен для работы с массивом объектов класса Worker.


Объекты типа Worker могут быть добавлены в массив методом addWorker. Метод printArray используется для вывода всех
работников в массиве на экран. Методы addWorker и printArray помечены как protected, что означает, что они доступны
только внутри класса ArrayWorkers и его подклассов. Массив workers является полем класса и доступен через
методы getWorkers и setWorkers.
 */
import java.util.Arrays;

public class ArrayWorkers {
    protected Worker[] workers;

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public ArrayWorkers(Worker[] workers) {
        this.workers = workers;
    }

    protected Worker[] addWorker(Worker worker, Worker[] workers) {
        int lengthArray = workers.length;
        if (workers.length == 0) {
            Worker[] newWorkers = {worker};
            return newWorkers;
        } else {
            Worker[] newWorkers = new Worker[lengthArray + 1];
            for (int i = 0; i < lengthArray; i++) {
                newWorkers[i] = workers[i];
            }
            newWorkers[lengthArray] = worker;
            return newWorkers;
        }
    }

    protected void printArray(Worker[] workers) {
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
