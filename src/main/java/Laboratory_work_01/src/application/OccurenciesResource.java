package Laboratory_work_01.src.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OccurenciesResource implements Occurencies {

    @Override
    public void getOccurencies(String[] sources, String[] words, String res) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start the program...");

        clearFile(res);
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        Object monitor = new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (String source : sources) {
            SearchOfResource searchOfResource = new SearchOfResource(source, wordSet, monitor);
            executorService.execute(searchOfResource);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finishTime = (System.currentTimeMillis() - startTime);
        System.out.println("Program finished in " + (finishTime) + " milliseconds or " + (finishTime / 1000) + " seconds");
    }

    private void clearFile(String filename) throws IOException {
        FileOutputStream writer = null;
        writer = new FileOutputStream(filename);
        writer.write(("Clear file" + "\n").getBytes());
        System.out.println("Completed clearing the file");
        writer.close();
    }

}
