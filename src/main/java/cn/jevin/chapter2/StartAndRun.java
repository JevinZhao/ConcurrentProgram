package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * 演示start 与 run方法的区别
 */
@Slf4j(topic = "c.StartAndRun")
public class StartAndRun {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("t1..running");
            }
        };
        //直接调用run，都是主线程在调用
        //t1.run();
        t1.start();
        log.debug("main..run");

    }
}
