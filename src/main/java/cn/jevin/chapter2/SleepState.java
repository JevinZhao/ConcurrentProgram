package cn.jevin.chapter2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 *  sleep方法前后线程状态变化
 */
@Slf4j(topic = "c.SleepState")
public class SleepState {
    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @SneakyThrows
            @Override
            public void run() {
                log.debug("enter sleep...");
                    Thread.sleep(2000);
            }
        };
        System.out.println(t1.getState());//NEW
        t1.start();
        System.out.println(t1.getState());//RUNNABLE
        //主线程睡一下，防止t1线程还没执行就输出打印其状态
        Thread.sleep(500);
        System.out.println(t1.getState());//TIMED_WAITING
    }
}
