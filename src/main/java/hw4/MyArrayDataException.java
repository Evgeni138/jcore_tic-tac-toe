package hw4;
/*
Данный код описывает класс `MyArrayDataException`, который является наследником абстрактного класса `MyArrayException`.
 */
public class MyArrayDataException extends MyArrayException{

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MyArrayDataException(String message, String str, int x, int y) {
        super(message, str);
        this.x = x;
        this.y = y;
    }
}
