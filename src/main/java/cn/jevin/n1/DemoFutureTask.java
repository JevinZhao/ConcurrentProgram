package cn.jevin.n1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口，重写call方法，配合futuretask接收返回结果
 */
@Slf4j(topic = "c.FutureTask")
public class DemoFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //任务
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("futuretask...");
                Thread.sleep(2000);
                return 100;
            }
        });
        //线程
        Thread t = new Thread(task, "t");
        t.start();
        //获取结果
        log.debug("{}",task.get());
    }
}
