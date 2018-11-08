package hw4;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox {
    private static Set<Object> objectSet;

    public ObjectBox(int sizeObjectBox) throws NotNumberInSetException {
        MySet mySet = new MySet(sizeObjectBox);
        checkNumberSetToObjectSet(mySet);
    }

    public ObjectBox() {
    }

    public Set<Object> getObjectSet() {
        return objectSet;
    }

    public static void setObjectSet(Set<Object> objectSet) {
        ObjectBox.objectSet = objectSet;
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
        Set<Double> newSet = new HashSet<>();
        for (Object element : objectSet) {
            Double d = Double.parseDouble(String.valueOf(element));
            double newElement = d / (double) div;
            newSet.add(newElement);
        }
        return newSet;
    }

    public void addObject(Object object) throws NotNumberInSetException {
        objectSet.add(object);
    }


    public void findObject(Object object) {
        for (Object element : objectSet) {
            if (element.equals(object)) {
                System.out.println("Элемент " + element + " найден!");
            }
        }
    }

    public String dump() {
        return "Коллекция objectSet в кол-ве " + objectSet.size() + " элементов = " + objectSet;
    }
}




