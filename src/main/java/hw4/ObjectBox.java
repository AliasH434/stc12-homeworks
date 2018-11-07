package hw4;

import java.util.HashSet;
import java.util.Set;

class ObjectBox {
    private static Set<Object> objectSet;

    public ObjectBox(int sizeObjectBox) throws NotNumberInSetException {
        MySet mySet = new MySet(sizeObjectBox);
        checkNumberSetToObjectSet(mySet);
    }

    public Set<Object> checkNumberSetToObjectSet(MySet numberSet) throws NotNumberInSetException {
        objectSet = new HashSet<>();
        for (Number nums : numberSet.getClassSet()) {
            objectSet.add(nums);
            if (nums instanceof Number) {

            } else {
                throw new NotNumberInSetException("Value in Set is not a Number: " + nums);
            }
        }

        return objectSet;
    }

    public int summator() {
        int sum = 0;
        for (Object element : objectSet) {
            sum += (Integer) element;
        }
        return sum;
    }

    public Set<Double> splitter(int div) {
        Set newSet = new HashSet<>(objectSet.size());
        for (Object element : objectSet) {
            double newElement = (double) element / div;
            newSet.add(newElement);
        }
        return newSet;
    }

    public void addObject(Object object) {
        objectSet.add(object);
    }


    public void findObject(Object object) {
        for (Object element : objectSet) {
            if (element.equals(object)) {
                System.out.println("Элемент " + element + " найден!");
            } else System.out.println("Данный объект не найден.");
        }
    }

    public String dump() {
        return "Коллекция objectSet в кол-ве " + objectSet.size() + " элементов = " + objectSet;
    }
}




