package Laboratory_work_01.src.application;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

public class SearchOfResource implements Runnable {

    private String source = null;
    private HashSet<String> wordsSet = null;
    private Object monitor;

    public SearchOfResource(String source, HashSet<String> wordsSet, Object monitor) {
        this.source = source;
        this.wordsSet = wordsSet;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " run");
        startTheSearch();
    }

    // выполняет поиск искоемых слов из "wordSet" в ресурсе "source"
    public void startTheSearch() {
        StringBuffer sentenceBuffer = new StringBuffer();
        boolean containsWord = false;
        int pointIndex;

        Scanner scannerSource = getScannerSource(source);
        while (scannerSource.hasNext()) {
            String readWord = scannerSource.next();

            if ((pointIndex = checkEndOfSentence(readWord)) > 1) {
                String firstWord = readWord.substring(0, pointIndex + 1);
                String secondWord = readWord.substring(pointIndex + 1).trim();
                containsWord = isWordPresent(firstWord, wordsSet);

                sentenceBuffer.append(readWord.substring(0, pointIndex + 1) + " ");

                if (containsWord) {
                    writeToResultFile(sentenceBuffer);
                }

                sentenceBuffer.setLength(0);
                sentenceBuffer.append(secondWord);
            } else {
                sentenceBuffer.append(readWord + " ");
            }
        }
        scannerSource.close();
    }

    // чтение ресурса из потоков
    public Scanner getScannerSource(String source) {
        boolean httpBollean = (source.trim().indexOf("http")) == 0;
        boolean ftpBoollean = (source.trim().indexOf("http")) == 0;
        Scanner sourceScanner = null;
        if (httpBollean || ftpBoollean) {
            try {
                sourceScanner = new Scanner(new URL(source).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                sourceScanner = new Scanner(new File(source));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return sourceScanner;
    }

    // записывает предложение в результирующий файл
    public void writeToResultFile(StringBuffer string) {
        synchronized (monitor) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(ReadFile.RESULT_FILE), true))) {
                writer.write(String.valueOf(string) + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //проверяет строку на наличие символов '.', '!', '?'
    private int checkEndOfSentence(String word) {
        int pointIndex;
        if ((pointIndex = word.indexOf(".")) > -1 || (pointIndex = word.indexOf("!")) > -1 || (pointIndex = word.indexOf("?")) > -1) {
            return pointIndex;
        } else {
            return -1;
        }
    }

    // проверяем если слово есть в списке искоемых слов
    private boolean isWordPresent(String word, HashSet<String> set) {
        word = word.replaceAll("\\p{Punct}", "").replaceAll("\n", "");
        String lowerCaseWord = word.toLowerCase();
        return set.contains(lowerCaseWord);
    }
}
