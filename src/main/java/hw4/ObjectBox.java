package hw4;

import hw3.MathBox;

import java.util.HashSet;
import java.util.Set;

class ObjectBox extends MathBox {
    private Set<Object> objectSet;

    public ObjectBox(int sizeObjectBox) {
    }

    public Set<Object> convertNumberSet_toObjectSet(Set<Number> integerSet) {

        Set<Object> objectSet = new HashSet<Object>();

        for (Number integer : integerSet) {
            objectSet.add(integer);
        }

        return objectSet;
    }

    public Set<Object> addObject(Object object) {
        objectSet.add(object);
        return objectSet;
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



