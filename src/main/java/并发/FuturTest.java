package 并发;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FuturTest {
    private static class Mytask implements Callable{

        @Override
        public Object call() throws Exception {
            int x=0;
            while(x<10){
                x++;
                Thread.sleep(100);
            }
            return x;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task =new FutureTask<>(new Mytask());
        new Thread(task).start();
        System.out.println("执行其他任务");
        System.out.println("获得任务执行结果："+ task.get());
    }
}
