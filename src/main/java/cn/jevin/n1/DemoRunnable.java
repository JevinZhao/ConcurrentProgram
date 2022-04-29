package cn.jevin.n1;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现Runnable接口，重写run()方法
 */
@Slf4j(topic = "c.Runnable")
public class DemoRunnable {
    public static void main(String[] args) {
        //实现Runnable接口,任务对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //执行的任务
                log.debug("runnable thread");
            }
        };
        Thread t = new Thread(runnable,"t");
        //启动线程
        t.start();
        log.debug("main thread run");
    }
}
