package cn.jevin.n1;

import cn.jevin.utils.FileReader;
import lombok.extern.slf4j.Slf4j;


/**
 * 同步等待
 */
@Slf4j(topic ="c.Sync")
public class Sync {
    public static void main(String[] args) {
        FileReader.read(Constants.FILE_FULL_PATH);
        log.debug("do other things ...");
    }
}
