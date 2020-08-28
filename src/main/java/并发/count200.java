package 并发;

import org.junit.runner.Runner;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class count200 {
    static int ret=0;

    public static void main(String[] args) throws Exception {
        myThread one =new myThread();
        myThread two =new myThread();
        Thread a =new Thread(one);
        Thread b =new Thread(two);
        a.start();
        b.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(ret);
    }
    static class myThread implements Runnable{
        ReentrantLock lock =new ReentrantLock();
        @Override
        public  void run(){
            for(int i=0;i<1000000;i++){

                lock.lock();
                try {
                    ret++;
                }finally {
                    lock.unlock();
                }
            }


        }
    }
}
