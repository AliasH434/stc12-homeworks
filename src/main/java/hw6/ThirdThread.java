package hw6;

public class ThirdThread extends Thread {

    private int time;
    private String message;

    public ThirdThread(int time, String message) {
        this.time = time;
        this.message = message;
    }

    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(time);
                System.out.println(message);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

