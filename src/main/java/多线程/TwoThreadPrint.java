package 多线程;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class TwoThreadPrint {
    static final Object lock=new Object();
    private static int i=1;


    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while(i<=100){
                        lock.notify();
                        log.info(""+i);
                        i++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    synchronized (lock){
                        lock.notifyAll();
                    }

                }
            }
        },"t1");
        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=100){
                    synchronized (lock) {
                        lock.notify();
                        log.info(""+i);
                        i++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (lock){
                    lock.notifyAll();
                }

            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("end");
    }
}
