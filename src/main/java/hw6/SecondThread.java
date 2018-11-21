package hw6;

public class SecondThread extends Thread {

    private int time;
    private String message;

    public SecondThread(int time, String message) {
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


