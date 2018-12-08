package hw7;

import java.util.*;

public class MathBox implements MathBoxInterface {
    private Set<Integer> mySet;

    public MathBox() {
        List<Integer> list = Arrays.asList(new MyArray().createMyArray());
        mySet = new TreeSet<Integer>(list);
    }

    @Override
    public int summator() {
        int sum = 0;
        for (Integer element : mySet) {
            sum += element;
        }
        return sum;
    }

    @Override
    public Set<Double> splitter(int div) {
        Set newSet = new TreeSet();
        for (Integer element : mySet) {
            double newElement = (double) element / div;
            newSet.add(newElement);
        }
        return newSet;
    }

    @Override
    public String deleteElement(Integer num) {
        for (Integer element : mySet) {
            if (element.equals(num)) {
                mySet.remove(element);
                break;
            }
        }
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(mySet, mathBox.mySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mySet);
    }

    @Override
    public String toString() {
        return "Коллекция mySet в кол-ве " + mySet.size() + " элементов = " + mySet;
    }
}
