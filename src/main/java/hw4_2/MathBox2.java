package hw4_2;


import hw4.NotNumberInSetException;
import hw4.ObjectBox;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MathBox2 extends ObjectBox {
    private Set<Integer> mySet;

    public MathBox2(int sizeMySet) {
        try {
            ObjectBox objectBox = new ObjectBox(sizeMySet);
            mySet = new HashSet<>();
            for (Object obj : getObjectSet()) {
                mySet.add(Integer.parseInt(String.valueOf(obj)));
            }
        } catch (NotNumberInSetException e) {
            System.out.println("Сработало исключение");
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(mySet);
    }

    @Override
    public String toString() {
        return "Коллекция mathSet в кол-ве " + mySet.size() + " элементов = " + mySet;
    }
}

