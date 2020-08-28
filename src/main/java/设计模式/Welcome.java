package 设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

interface Cal{
    int add(int a,int b);
    int multiply(int a,int b);
}
class Option implements Cal{

    public int add(int a,int b){
        return a+b;
    }
    public int multiply(int a,int b){
        return a*b;
    }

}
public class Welcome implements InvocationHandler{
    private Object object=null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用函数："+method.getName()+"参数为"+Arrays.toString(args));
        Object result =method.invoke(object,args);
        System.out.println("结果为"+result);
        return result; //如果是null的话会报空指针异常，因为会执行（Integer）null.intValue()
    }

    public Object bind(Object o){
        this.object=o;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        Cal proxy=(Cal) new Welcome().bind(new Option());
        proxy.multiply(1,5);
    }
}


