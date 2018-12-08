package hw7;

/*
Работаем с проектом из Урока 3

1.      Создать прокси для класса mathBox (подумайте, что для этого надо добавить к классу)

2.      В вызов методов класса через прокси добавить логирование в консоль при использовании аннотации Logged

3.      В вызов методов класса через прокси добавить очистку поля-контейнера при использовании аннотации ClearData
        у вызванного метода

Нужные аннотации добавить к проекту


Дополнительное задание (не на оценку)

Добавить в проект сериализации объект-прокси, который будет при использовании аннотации UseXml
выполнять сериализацию-десериализацию в XML вместо нативной. Саму сериализацию-десериализацию можно заглушить.
Главное разобраться с прокси и созданием собственных аннотаций.

 */

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MathBoxInterface mathBoxInterface = new MathBox();
        MathBoxProxy mathBoxProxy = new MathBoxProxy(mathBoxInterface);
        MathBoxInterface ProxyInterface = (MathBoxInterface) Proxy.newProxyInstance(MathBoxProxy.class.getClassLoader(), new Class[]{MathBoxInterface.class}, mathBoxProxy);

        System.out.println(mathBoxInterface.toString());
        System.out.println("1.Mетод summator, где Сумма элементов равна: " + mathBoxInterface.summator());
        int div1 = 2;
        System.out.println("2.Mетод splitter, где Коллекция после деления на " + div1 + " получилась: " + mathBoxInterface.splitter(div1));
        int delete1 = 2;
        System.out.println("3.Если элемент равен " + delete1 + ", удалить его! : " + mathBoxInterface.deleteElement(delete1));

        System.out.println("\nВыполнение тех же медотов используя проксирование!");
        LoggList.logList.add("1.Mетод summator: " + (ProxyInterface.summator() + 10));
        int div2 = 5;
        LoggList.logList.add("2.Mетод splitter, деления элементов коллекции на " + div2 + " получилась: " + ProxyInterface.splitter(div2));

        int delete2 = 0;
        LoggList.logList.add("3.Если элемент равен " + delete2 + ", удалить его! : " + ProxyInterface.deleteElement(delete2));

        for (String str : LoggList.logList) {
            System.out.println(str);
        }
    }
}
