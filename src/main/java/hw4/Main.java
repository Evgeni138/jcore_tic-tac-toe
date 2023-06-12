package hw4;
/*
В данном коде создается экземпляр класса MyArray, который содержит методы для проверки двумерного массива на
соответствие определенным условиям.
Метод `initMyArray()` инициализирует массив строк заданного размера, который возвращает в переменную `test`.
Далее приводится проверка каждой строки на размер и каждого элемента массива на тип, который должен быть числом.
Если какое-то условие не выполняется, создается исключение MyArraySizeException или MyArrayDataException.
Если ошибок не найдено, вызывается метод `sumElementsArray()` для подсчета суммы элементов массива, который приводится
к типу int с помощью метода `castMyArray()`.
 */
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        String[][] test = myArray.initMyArray();
        boolean flag = true;
        for (int i = 0; i < test.length; i++) {
            try {
                myArray.checkSize(test[i]);
            } catch (MyArraySizeException e) {
                System.out.printf("Размер строки %d массива не соответствует размеру по условию задачи.\n", i + 1);
                flag = false;
            }
        }
        for (int i = 0; i < test.length; i++) {

            for (int j = 0; j < test[i].length; j++) {
                try {
                    myArray.checkType(test[i][j], i, j);
                } catch (MyArrayDataException e) {
                    System.out.printf("Элемент на %d месте %d строчки не является числом.\n", j + 1, i + 1);
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.printf("Сумма элементов массива равна %d",
                    myArray.sumElementsArray(myArray.castMyArray(test)));
        }

    }
}
