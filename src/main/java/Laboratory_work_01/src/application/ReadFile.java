package Laboratory_work_01.src.application;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public static final String RESULT_FILE = "D:\\00_Programming\\JavaEE\\ru\\innopolis\\Homeworks\\src\\main\\java\\Laboratory_work_01\\src\\res\\ResultOfSearch.txt";
    private static String sourcesFile = "D:\\00_Programming\\JavaEE\\ru\\innopolis\\Homeworks\\src\\main\\java\\Laboratory_work_01\\src\\res\\Sources.txt";
    private static String wordsFile = "D:\\00_Programming\\JavaEE\\ru\\innopolis\\Homeworks\\src\\main\\java\\Laboratory_work_01\\src\\res\\Words.txt";

    // массив ресурсов
    public static String[] getSources() {
        return getArrayFromFile(sourcesFile);
    }

    // массив слов
    public static String[] getWords() {
        String[] lines = getArrayFromFile(wordsFile);
        ArrayList<String> wordList = new ArrayList<>();
        for (String wordLine : lines) {
            wordLine = wordLine.replaceAll("\\p{Punct}", "").replaceAll("\n", "");
            wordLine = wordLine.toLowerCase();
            String[] arrayWords = wordLine.split(" ");
            wordList.addAll(Arrays.asList(arrayWords));
        }
        String[] wordsAray = new String[wordList.size()];
        wordList.toArray(wordsAray);

        return wordsAray;
    }

    // извлечение массива строк из файла
    private static String[] getArrayFromFile(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] sources = new String[lines.size()];
        lines.toArray(sources);
        return sources;
    }

    // получить имя файла с описанием адресов ресурсов
    public static void setSourcesFile(String sourcesFile) {
        ReadFile.sourcesFile = sourcesFile;
    }

    // получить имя файла с искоемыми словами
    public static void setWordsFile(String wordsFile) {
        ReadFile.wordsFile = wordsFile;
    }

    // записывает имена файлов из массива в файл "sourcesFile"
    public static void writeToSourcesFile(String fieldName) {
        String[] strings = getFileNames(fieldName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(ReadFile.sourcesFile)))) {
            for (String string : strings) {
                writer.write(string + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // получение массива имен файлов
    private static String[] getFileNames(String fieldName) {
        File folder = new File(fieldName);
        File[] listOfFiles = folder.listFiles();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                results.add(fieldName + listOfFiles[i].getName());
            }
        }
        return results.toArray(new String[0]);
    }

}
