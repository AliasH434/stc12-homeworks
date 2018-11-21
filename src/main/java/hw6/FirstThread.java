package hw6;

public class FirstThread extends Thread {

    private long time = System.currentTimeMillis();

    public FirstThread() {
        this.time = time;
    }

    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                long timeWorkCode = System.currentTimeMillis() - time;
                System.out.println(timeWorkCode / 1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

