package hw6;

public class ThirdThread extends Thread {
    String massage;

    public void setWord(String string) {
        this.massage = massage;
    }

    @Override
    public void run() {
        System.out.println(massage);
    }
}
