package hw7;

import java.util.Random;

public class MyArray {
    Random random = new Random();

    public Integer[] createMyArray() {
        Integer[] myArray = new Integer[20];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(100);
            equalsElementInMyArray(myArray, i);
        }
        return myArray;
    }

    private void equalsElementInMyArray(Integer[] myArray, int i) {
        int j = 0;
        while (j < i) {
            if (myArray[i] == myArray[j]) {
                myArray[i] = random.nextInt(100);
                j = 0;
            }
            j++;
        }
    }
}


