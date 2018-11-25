package hw6;

public class MonitorThread extends Thread {

    private Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {
            synchronized (monitor) {
                try {
                    monitor.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.monitor.notifyAll();
            }

        }
    }
}