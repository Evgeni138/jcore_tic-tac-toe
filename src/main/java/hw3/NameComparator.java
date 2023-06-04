package hw3;
/*
Данный класс NameComparator реализует интерфейс Comparator, который используется для сравнения объектов класса Worker
на основе их имени (полученного с помощью метода getName()).

Основной метод класса - compare(Worker o1, Worker o2), в котором сравниваются переданные на вход объекты класса
Worker o1 и o2. Для сравнения используется метод compareTo() класса String, который сравнивает лексикографически
значения строк (т.е. сравнивает первые символы строк, затем - вторые и т.д.).

Если o1.getName() меньше o2.getName(), метод compare() вернет отрицательное число (o1 < o2). Если o1.getName() больше
o2.getName(), метод вернет положительное число (o1 > o2). Если o1.getName() равно o2.getName(),
метод вернет 0 (o1 = o2).

Таким образом, данный класс может использоваться для сортировки списка объектов класса Worker по их имени в алфавитном
порядке (от A до Z).
 */
import java.util.Comparator;

public class NameComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
