package hw7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxProxy implements InvocationHandler {
    private MathBoxInterface mathBoxInterface;

    public MathBoxProxy(MathBoxInterface mathBoxInterface) {
        this.mathBoxInterface = mathBoxInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = mathBoxInterface.getClass();
        Method[] methods = clazz.getMethods();
        Object result;

        if (clazz.getClass().getAnnotation(Logged.class) != null) {

            LoggList.logList.add("Вызываемый метод: " + method.getName());
            result = method.invoke(mathBoxInterface, args);
        } else {
            result = method.invoke(mathBoxInterface, args);
        }
        for (Method metod : methods) {
            if (((metod.getAnnotation(ClearData.class)) != null) && metod.getName().equals(method.getName())) {
                LoggList.logList.clear();
            }
        }
        return result;
    }
}
