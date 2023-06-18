package lection5;
/**
 * Класс Tree используется для вывода древовидной структуры файловой системы на консоль.
 */

import java.io.File;
import java.util.ArrayList;

public class Tree {

    /**
     * Метод print() выводит на консоль все файлы и папки, которые находятся в передаваемом в него объекте File.
     * Вывод происходит в древовидном виде с отступами и символами подчеркивания, которые образуют ветки дерева.
     * @param file относительный путь папки для отрисовки
     * @param indent отступ
     * @param isLast является ли элемент последним
     *
     * Метод состоит из следующих этапов:
     * 1. Отображение отступа в консоли.
     * 2. Проверка, является ли текущая папка последней в текущей ветке, и соответствующее отображение символа
     *               ">" или "|".
     * 3. Вывод имени текущей папки на консоль.
     * 4. Получение всех файлов и папок в текущей папке.
     * 5. Разбиение полученных файлов на две группы: папки и файлы.
     * 6. Определение количества папок в данной папке.
     * 7. Для каждой папки вызывается метод print() с соответствующими параметрами.
     * 8. Для каждого файла выводится его имя.
     * 9. Рекурсивный вызов метода для каждой папки.
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // нарисовать отступ
        if (isLast) {
            System.out.print("└─");
            indent += " ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        ArrayList<File> fileSimples = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            } else {
                fileSimples.add(files[i]);
            }

        }

        int subDirCount = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCount == files.length - 1);
                subDirCount++;
            }
        }

        for (int i = 0; i < fileSimples.size(); i++) {
            if (i != fileSimples.size() - 1) {
                print(fileSimples.get(i), indent, false);
            } else {
                print(fileSimples.get(i), indent, true);
            }
        }

    }

    public static void main(String[] args) {
        print(new File("C:\\Example\\jcore\\src\\main\\java"), "", true);
    }
}
