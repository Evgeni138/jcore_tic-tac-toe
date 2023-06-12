package hw4;
/*
Данный код описывает класс `MyArraySizeException`, который является наследником абстрактного класса `MyArrayException`.
 */
public class MyArraySizeException extends MyArrayException{

    public MyArraySizeException(String message, String str) {
        super(message, str);
    }
}
