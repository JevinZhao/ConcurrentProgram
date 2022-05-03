package cn.jevin.chapter3;

import lombok.extern.slf4j.Slf4j;

import static cn.jevin.utils.Sleeper.sleep;

/**
 * 线程8锁
 * 考察 synchronized 锁住的是哪个对象
 */
@Slf4j(topic = "c.EightLocks")
public class EightLocks {

    public static void main(String[] args) {
        Number n1 = new Number();
        //Number n2 = new Number();
        new Thread(() -> {
            log.debug("begin");
            n1.a();
        }).start();
        new Thread(() -> {
            log.debug("begin");
            n1.b();
            //n2.b();
        }).start();
    }
}

@Slf4j(topic = "c.Number")
class Number {
    public synchronized void a() {
        //sleep(1);
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }
}
