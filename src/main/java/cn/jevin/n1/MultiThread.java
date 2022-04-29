package cn.jevin.n1;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程交替进行
 */
@Slf4j(topic ="c.MultiThread")
public class MultiThread {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                log.debug("t1 ...");
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                log.debug("t2 ...");
            }
        },"t2").start();
    }
}
