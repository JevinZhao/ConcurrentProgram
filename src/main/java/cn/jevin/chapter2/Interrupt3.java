package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;


/**
 * Interrupt方法的作用：2.打断park线程,打断标志为true时会让park失效
 */
@Slf4j(topic = "c.Interrupt3")
public class Interrupt3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark..");
            log.debug("打断状态：{}",Thread.currentThread().isInterrupted());
        },"t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();//类似于提供一个打断标记，不提供实际的作用

    }
}
