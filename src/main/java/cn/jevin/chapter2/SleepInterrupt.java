package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 *  sleep打断前后线程状态变化
 */
@Slf4j(topic = "c.SleepInterrupt")
public class SleepInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1"){

            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.debug("wake up...");
                }
            }
        };
        System.out.println(t1.getState());//NEW
        t1.start();
        System.out.println(t1.getState());//RUNNABLE
        //主线程睡一下，防止t1线程还没执行就输出打印其状态
        Thread.sleep(500);
        System.out.println(t1.getState());//TIMED_WAITING
        //打断睡眠
        t1.interrupt();
        Thread.sleep(2500);
        System.out.println(t1.getState());//TERMINATED
    }
}
