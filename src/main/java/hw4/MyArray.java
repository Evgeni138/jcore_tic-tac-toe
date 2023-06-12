package hw4;
/*
Класс MyArray для работы с двумерными массивами.
Метод initMyArray() позволяет инициализировать двумерный массив типа String.
Метод printMyArray() печатает двумерный массив типа int[][] в консоль.
Метод castMyArray() выполняет преобразование двумерного массива типа String[][] в int[][].
Метод checkSize() проверяет, соответствует ли размер строки условию (иметь длину 4).
Метод checkType() проверяет, является ли переданная строка числом.
Метод sumElementsArray() суммирует все элементы в двумерном массиве типа int[][].

 */
import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    private final int x= 4;

    public String[][] initMyArray() {
        Scanner iScanner = new Scanner(System.in);
        String[][] myArray = new String[4][];
        System.out.println("Введите четыре строки по четыре числа через пробел");
        for (int i = 0; i < x; i++) {
            System.out.printf("Введите %d строку:", i + 1);
            myArray[i] = iScanner.nextLine().split(" ");
        }
        return myArray;
    }

    public void printMyArray(int[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(Arrays.toString(myArray[i]));
        }
    }

    public int[][] castMyArray (String[][] myArray){
        int[][] resultArray = new int[myArray.length][myArray[myArray.length - 1].length];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                try {
                    checkType(myArray[i][j], i, j);
                    resultArray[i][j] = Integer.parseInt(myArray[i][j]);
                } catch (MyArrayDataException e) {
                    System.out.printf("Элемент на %d месте %d строчки не является числом.\n", j + 1, i + 1);
                }
            }
        }
        return resultArray;
    }

    public boolean checkSize(String[] str) throws MyArraySizeException {
        if (str.length == 4)
            return true;
        else throw new MyArraySizeException("Размер строки массива не соответствует заданным условиям",
                Arrays.toString(str));
    }

    public boolean checkType(String str, int i, int j) throws MyArrayDataException {
        if (str.matches("-?\\d+"))
            return true;
        else {
            throw new MyArrayDataException("Элемент не является числом", str, i, j);
        }
    }

    public int sumElementsArray(int[][] myArray) {
        int result = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                result += myArray[i][j];
            }
        }
        return result;
    }
}
