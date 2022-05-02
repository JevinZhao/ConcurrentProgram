package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;

import static cn.jevin.utils.Sleeper.sleep;


/**
 * 守护线程
 */
@Slf4j(topic = "c.DaemonThread")
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        log.debug("开始运行...");
        Thread t1 = new Thread(() -> {
            log.debug("开始运行...");
            sleep(2);
            log.debug("运行结束...");//主进程结束啦，守护线程也会停止
        }, "daemon");
        // 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();
        sleep(1);
        log.debug("运行结束...");
    }
}
