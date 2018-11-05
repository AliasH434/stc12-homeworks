package hw4;

import hw3.MathBox;

import java.util.HashSet;
import java.util.Set;

class ObjectBox extends MathBox {
    private static Set<Object> objectSet;

    public ObjectBox(int sizeObjectBox) {
        MySet mySet = new MySet(sizeObjectBox);
        try {
            convertNumberSet_toObjectSet((Set<Number>) mySet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Object> convertNumberSet_toObjectSet(MySet numberSet) throws Exception {

        objectSet = new HashSet<Object>();
        for (MySet nums : numberSet) {
            objectSet.add(nums);
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
            } else System.out.println("Данный объект не найден.");
        }
    }

    public String dump() {
        return "Коллекция objectSet в кол-ве " + objectSet.size() + " элементов = " + objectSet;
    }
}



