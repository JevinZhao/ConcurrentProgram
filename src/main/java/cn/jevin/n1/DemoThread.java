package cn.jevin.n1;

import lombok.extern.slf4j.Slf4j;

/**
 * 直接 new Thread类，重写run()方法
 * 或者说，继承Thread类 ，重写run()方法
 */
@Slf4j(topic = "c.Thread")
public class DemoThread {
    public static void main(String[] args) {
        // 创建线程
        Thread t = new Thread("t"){
            @Override
            public void run() {
                log.debug("t thread run");
            }
        };
        // 启动线程
        t.start();
        log.debug("main thread run");
    }
}
