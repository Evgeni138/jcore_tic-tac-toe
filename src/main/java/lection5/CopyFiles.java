package lection5;
/**
 * Класс для копирования файлов из одной директории в другую
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFiles {
    public static void main(String[] args) {
        File source = new File("C:\\Example\\jcore\\src\\main\\java\\lection5");
        File directory = new File("C:\\Example\\jcore\\src\\main\\java\\lection5\\backup");
        directory.mkdir();
        // Получение списка файлов из исходной директории
        List<File> list = new ArrayList<>();
        // Копирование каждого файла из списка
        list = List.of(source.listFiles());
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isDirectory())
                copyFile(list.get(i), directory);
        }
    }
/**
        * Получение имени файла из полного пути
     * @param file файл, для которого нужно получить имя
     * @return имя файла
     */
    private static String name(File file) {
        String source = file.getName();
        String[] list = source.split("\\\\");
        return list[list.length - 1];
    }

    /**
     * Создание нового имени файла в директории назначения
     * @param directory директория назначения
     * @param fileName имя файла
     * @return новое имя файла
     */
    private static String newName(String directory, String fileName) {
        return directory + "\\" + fileName;
    }

    /**
     * Копирование файла
     * @param file файл для копирования
     * @param destination директория, в которую копируется файл
     */
    private static void copyFile(File file, File destination) {
        File newFile = new File(newName(destination.getAbsolutePath(), file.getName()));
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = is.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
