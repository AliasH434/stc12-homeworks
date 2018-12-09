package Laboratory_work_01.src.application;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OccurenciesResource implements Occurencies {

    private static Logger LOGGER = Logger.getLogger(OccurenciesResource.class);

    @Override
    public void getOccurencies(String[] sources, String[] words, String res) throws IOException {
        long startTime = System.currentTimeMillis();
        LOGGER.info("Start the program...");

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
            LOGGER.error(e.getMessage());
        }

        long finishTime = (System.currentTimeMillis() - startTime);
        LOGGER.info("Program finished in " + (finishTime) + " milliseconds or " + (finishTime / 1000) + " seconds");
    }

    private void clearFile(String filename) throws IOException {
        FileOutputStream writer = null;
        writer = new FileOutputStream(filename);
        writer.write(("Clear file" + "\n").getBytes());
        LOGGER.info("Completed clearing the file");
        writer.close();
    }

}
