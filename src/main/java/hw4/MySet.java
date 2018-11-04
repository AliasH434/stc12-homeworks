package hw4;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class MySet {
    private Set<Number> classSet;

    public MySet(int sizeClassSet) {
        classSet = createMySet(sizeClassSet);
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
        return "Коллекция mySet в кол-ве " + classSet.size() + " элементов = " + classSet;
    }

    public Set<Number> getClassSet() {
        return classSet;
    }
}
