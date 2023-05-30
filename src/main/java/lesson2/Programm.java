package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Programm {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '·';
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы выйграли!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Вы проиграли!"))
                    break;

            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        fieldSizeX = 7;
        fieldSizeY = 7;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка инрового поля
     */
    private static void printField() {
//
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[j][i] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода X и Y через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN; // Check x y
    }

    /**
     * Проверка, является ячейка пустой
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива игрового поля)
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI; // Check x y
    }

    /**
     * Проверка победы. В поле 3*3 поиск перебором трех совпадений
     *
     */
    static boolean checkWin(char c) {
        int turn = 0;
        // Проверка по вертикалям
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == c) turn += 1;
            }
            if (turn == 4) return true;
            turn = 0;
        }
        // Проверка по горизонталям
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] == c) turn += 1;
            }
            if (turn == 4) return true;
            turn = 0;
        }
        // Проверка по диагоналям
        for (int i = 0; i < fieldSizeX; i++) {
            if (field[i][i] == c) turn += 1;
            if (turn == 3) return true;
        }
        turn = 0;
        int j = fieldSizeY - 1;
        for (int i = 0; i < fieldSizeX; i++) {
            if (field[i][j] == c) turn += 1;
            if (turn == 3) return true;
            j--;
        }
        j = 0;
        return false;
    }

    static boolean checkWinOrigin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[2][0] == c && field[1][1] == c && field[0][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        return false;
    }

    /**
     * Проверка на ничью
     */
    static boolean checkDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(j, i)) return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     */
    static boolean gameCheck(char c, String str) {
        if (checkWinFour(c)) {
            System.out.println(str);
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    /**
     * Метод делает проверку на победу из четырех фишек, проходя во втором ветвлении по четырем лучам(направлениям)
     * и проверяя нет ли подряд четыре совпадения
     * @param c
     * @return
     */
    private static boolean checkWinFour(char c) {
        int turn = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) {
                    if (checkLine1(i, j, c) || checkLine2(i, j, c) || checkLine3(i, j, c) || checkLine4(i, j, c))
                        return true;

                }
            }
        }
        return false;
    }

    private static boolean checkLine1(int x, int y, char c) {
        int turn = 1;
        while ((y + 1) < fieldSizeY) {
            if (field[x][y+1] == c) {
                turn += 1;
                y += 1;
            } else break;
        }
        if (turn >= 4) return true;
        return false;
    }

    private static boolean checkLine2(int x, int y, char c) {
        int turn = 1;
        while ((x + 1) < fieldSizeX) {
            if (field[x+1][y] == c) {
                turn += 1;
                x += 1;
            } else break;
        }
        if (turn >= 4) return true;
        return false;
    }

    private static boolean checkLine3(int x, int y, char c) {
        int turn = 1;
        while ((x + 1) < fieldSizeY && (y + 1) < fieldSizeX) {
            if (field[x + 1][y + 1] == c) {
                turn += 1;
                x += 1;
                y += 1;
            } else break;
        }
        if (turn >= 4) return true;
        return false;
    }

    private static boolean checkLine4(int x, int y, char c) {
        int turn = 1;
        while ((x - 1) > 0 && (y + 1) < fieldSizeX) {
            if (field[x - 1][y + 1] == c) {
                turn += 1;
                x -= 1;
                y += 1;
            } else {
                break;
            }
        }
        if (turn >= 4) return true;
        return false;
    }
}