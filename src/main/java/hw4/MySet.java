package hw4;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class MySet {
    private Set<Number> numberSet;

    public MySet(int sizeClassSet) {
        numberSet = createMySet(sizeClassSet);
    }

    public Set<Number> createMySet(int sizeMySet) {
        Random random = new Random();
        Set<Number> newSet = new HashSet<Number>();
        for (int i = 0; i < sizeMySet; i++) {
            Number element = random.nextInt(100);
            newSet.add(element);
        }
        return newSet;
    }

    public String dump() {
        return "Коллекция mySet в кол-ве " + numberSet.size() + " элементов = " + numberSet;
    }


    public Set<Number> getClassSet() {
        return numberSet;
    }
}

