package Laboratory_work_01;

/*
Рализовать следующий интерфейс:

void getOccurencies(String[] sources, String[] words, String res) throws …;

Многоточие означает необходимые для реализации исключения

Функциональные требования: метод получает на вход массив адресов ресурсов (файлы, FTP, web-ссылки) и слов. Необходимо в многопоточном
режиме найти вхождения всех слов второго массива в ресурсы.
Если слово входит в предложение, это предложение добавляется в файл по адресу res. При начале исполнения метода файл очищается
(чтобы исключить наличие старой информации).

Все ресурсы текстовые. Необходимо определить оптимальную производительность. Возможны ситуации как с большим числом ресурсов
(>2000 текстовых ресурсов каждый <2кб), так и с очень большими ресурсами (ресурс>1ГБ).
Максимальный размер массива ресурсов 2000 элементов. Максимальный размер массива слов 2000 элементов. Предложение это
последовательность слов, начинающаяся с заглавной буквы и заканчивающаяся точкой, вопросительным знаком, восклицательным знаком,
или многоточием. Внутри предложения могут находиться знаки препинания.
Слово это последовательность символов кириллических, либо латинских.
 */

import Laboratory_work_01.src.application.Occurencies;
import Laboratory_work_01.src.application.OccurenciesResource;
import Laboratory_work_01.src.application.ReadFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String sources1 = "D:\\00_Programming\\JavaEE\\ru\\innopolis\\Homeworks\\src\\main\\java\\Laboratory_work_01\\test\\less1Gb\\";
        String sources2 = "D:\\00_Programming\\JavaEE\\ru\\innopolis\\Homeworks\\src\\main\\java\\Laboratory_work_01\\test\\more1GB\\";

        /** Назначение папки с ресурсами*/
        ReadFile.writeToSourcesFile(sources1);

        Occurencies occurencies = new OccurenciesResource();
        try {
            occurencies.getOccurencies(ReadFile.getSources(), ReadFile.getWords(), ReadFile.RESULT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
