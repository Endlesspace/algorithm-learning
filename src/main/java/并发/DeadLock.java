package 并发;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class DeadLock {
    static final Object lock1 =new Object();
    static final Object lock2 =new Object();
    static final Lock lock3 =new ReentrantLock();
    static final Lock lock4 =new ReentrantLock();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //lock1
                synchronized (lock1){
                    log.info("获得锁1");
                    synchronized (lock2){
                        log.info("get lock2");
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //lock1
                synchronized (lock2){
                    log.info("获得锁2");
                    synchronized (lock1){
                        log.info("get lock1");
                    }
                }
            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock3.lock();
                log.info("get 3");
                lock4.lock();
                log.info("get 4");
                lock4.unlock();
                lock3.unlock();

            }
        },"t3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock4.lock();
                log.info("get 4");
                boolean locked = lock3.tryLock();
                if(locked) {
                    log.info("get 3");
                    lock3.unlock();
                }
                lock4.unlock();

            }
        },"t4").start();
    }
}
