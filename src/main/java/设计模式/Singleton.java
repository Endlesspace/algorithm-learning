package 设计模式;

public class Singleton {
    private static Singleton singletoninstance;
    private Singleton(){} //私有化构造函数
    public static Singleton getInstance(){       //注意要声明为静态
        if(singletoninstance==null){
            singletoninstance=new Singleton();
        }
        return singletoninstance;
    }
}

class Singleton2{
    private static volatile Singleton2 instance;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){ //主要锁住整个类
                if(instance==null){
                    instance=new Singleton2();
                }
            }
        }
        return instance;
    }
}