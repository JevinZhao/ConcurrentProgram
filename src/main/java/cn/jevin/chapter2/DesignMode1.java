package cn.jevin.chapter2;

import lombok.extern.slf4j.Slf4j;


/**
 * 两阶段终止模式
 */
@Slf4j(topic = "c.DesignMode1")
public class DesignMode1 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        //启动监控类(一秒扫一次)
        tpt.Start();
        //主线程睡觉
        Thread.sleep(3000);
        tpt.stop();
    }
}

/**
 * 监控类
 */
@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {
    private Thread monitor;

    public void Start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);//睡眠中打断
                    log.debug("执行监控记录");//记录记录的时候被打断
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();//由于在睡眠中打断会清除打断标记，所以要重新设置一下
                }
            }
        });
        monitor.start();
    }
    public void stop(){
        monitor.interrupt();
    }
}
