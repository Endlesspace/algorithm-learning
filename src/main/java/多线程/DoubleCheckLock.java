package 多线程;

public class DoubleCheckLock {
    static volatile DoubleCheckLock doubleCheckLock;
    private DoubleCheckLock(){};
    public DoubleCheckLock getDoubleCheckLock(){
        if(doubleCheckLock==null){
            synchronized (DoubleCheckLock.class){
                if(doubleCheckLock==null){
                    doubleCheckLock=new DoubleCheckLock();

                }
            }
        }
        return doubleCheckLock;
    }
}
