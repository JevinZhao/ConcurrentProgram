package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 *  start方法前后线程状态变化
 */
@Slf4j(topic = "c.StartState")
public class StartState {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("t1..running");
            }
        };
        System.out.println(t1.getState());//new
        t1.start();
        System.out.println(t1.getState());//runnable
    }
}
