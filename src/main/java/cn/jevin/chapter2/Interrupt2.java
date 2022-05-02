package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;


/**
 * Interrupt方法的作用：2.打断正常线程
 */
@Slf4j(topic = "c.Interrupt2")
public class Interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("被打断啦，退出");
                    break;
                }
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();//类似于提供一个打断标记，不提供实际的作用

    }
}
