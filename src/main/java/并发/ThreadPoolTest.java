package 并发;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ThreadPoolTest {
    private static class Mytask implements Runnable{

        @Override
        public void run() {
            int i=0;
            while (i++<2){
                log.info("alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("current rejected task is: "+r.toString());
            }
        });
        for(int i=0;i<7;++i) {
            executorService.execute(new Mytask());
        }
        executorService.shutdown();
    }
}
