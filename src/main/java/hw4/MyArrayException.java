package hw4;
/*
Данный код описывает абстрактный класс `MyArrayException`, который является наследником стандартного класса `Exception`.


 */
public abstract class MyArrayException extends Exception{
    private String str;

    public String getMyArray() {
        return str;
    }

    public MyArrayException(String message, String str) {
        super(message);
        this.str = str;
    }
}
