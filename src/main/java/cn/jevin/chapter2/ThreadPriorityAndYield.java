package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 *  线程优先级与yield方法
 */
@Slf4j(topic = "c.ThreadPriorityAndYield")
public class ThreadPriorityAndYield {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count=0;
            for (;;){
                System.out.println("------>t1  "+count++);
            }
        };
        Runnable task2= () -> {
            int count=0;
            for (;;){
                //线程2增长慢
                //Thread.yield();
                System.out.println("          ------>t2  "+count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        //t1.setPriority(Thread.MIN_PRIORITY);
        //t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
