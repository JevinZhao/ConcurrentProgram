package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;


/**
 * Interrupt方法的作用:1.打断睡眠中的线程
 */
@Slf4j(topic = "c.Interrupt")
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("sleep...");
            try {
                Thread.sleep(5000);//wait，join会清空打断标记
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        Thread.sleep(2000);//奇怪，睡一秒和2秒不一样
        log.debug("interrupt");
        t1.interrupt();
        log.debug("打断标记：{}",t1.isInterrupted());
    }
}
