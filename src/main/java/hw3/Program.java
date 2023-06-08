package hw3;

import java.util.*;

/*
1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков)
и фиксированной оплатой (второй потомок).
а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
в) ** Реализовать интерфейсы для возможности сортировки массива (обратите ваше внимание на интерфейсы Comparator,
Comparable)
г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.


 */
public class Program {
    public static void main(String[] args) {
        Worker[] workers = {
                new Engineer("John", 33, 1000),
                new Handyman("Tom", 20, 5),
                new Engineer("Bill", 35, 1100),
                new Handyman("Karl", 40, 6),
                new Engineer("Dan", 43, 1300),
                new Handyman("Kurt", 37, 6)
        };

        System.out.println(Arrays.toString(workers));

        Comparator<Worker> comparatorSort = new PositionComparator().thenComparing(new NameComparator());

        ArrayList<Worker> workerArrayList = new ArrayList<>();
        workerArrayList.add(new Engineer("John", 33, 1000));
        workerArrayList.add(new Handyman("Tom", 20, 5));
        workerArrayList.add(new Engineer("Bill", 35, 1100));
        workerArrayList.add(new Handyman("Karl", 40, 6));
        workerArrayList.add(new Engineer("Dan", 43, 1300));
        workerArrayList.add(new Handyman("Kurt", 37, 6));

        Collections.sort(workerArrayList, comparatorSort);
        for (Worker worker : workerArrayList
        ) {
            System.out.println(worker);
        }

        System.out.println();

        Worker[] workers1 = new Worker[0];

        ArrayWorkers arrayWorkers = new ArrayWorkers(workers1);
        workers1 = arrayWorkers.addWorker((new Handyman("Kurt", 37, 6)), workers1);
        workers1 = arrayWorkers.addWorker((new Engineer("Dan", 43, 1300)), workers1);
        workers1 = arrayWorkers.addWorker((new Handyman("Karl", 40, 6)), workers1);
        workers1 = arrayWorkers.addWorker((new Engineer("Bill", 35, 1100)), workers1);
        workers1 = arrayWorkers.addWorker((new Handyman("Tom", 20, 5)), workers1);
        workers1 = arrayWorkers.addWorker((new Engineer("John", 33, 1000)), workers1);

        Arrays.sort(workers1, comparatorSort);
        for (Worker worker: workers1
             ) {
            System.out.println(worker);
        }
        arrayWorkers.printArray(workers1);
        System.out.println();

    }
}
