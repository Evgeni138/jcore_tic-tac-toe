package hw3;
/*
Данный класс PositionComparator реализует интерфейс Comparator, который используется для сравнения объектов класса
Worker на основе их должности (название класса).

Основной метод класса - compare(Worker a, Worker b), в котором сравниваются переданные на вход объекты класса
Worker a и b. Сравнение происходит на основе названия класса каждого объекта, полученного с помощью метода
getClass().getSimpleName().

Если a - объект класса Handyman, а b - объект класса Engineer, метод compare() вернет 1 (a > b). В обратном случае,
когда a - объект класса Engineer, а b - объект класса Handyman, метод вернет -1 (a < b). Если названия классов объектов
совпадают, то метод вернет 0 (a = b).

Таким образом, данный класс может использоваться для сортировки списка объектов класса Worker по их должности
(из класса-наследников Handyman и Engineer).
 */
import java.util.Comparator;

public class PositionComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker a, Worker b) {
        if (a.getClass().getSimpleName().equals("Handyman") && b.getClass().getSimpleName().equals("Engineer"))
            return 1;
        else if (a.getClass().getSimpleName().equals("Engineer") && b.getClass().getSimpleName().equals("Handyman"))
            return -1;
        else return 0;
    }
}
