package xyz.dongxiaoxia.modules.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
public class ExampleSchedule {
    private static final Logger logger = LoggerFactory.getLogger(ExampleSchedule.class);

    public static void init(){
        logger.info("======================ExampleSchedule init===========================");
    }

    public static void destroyed() {
        logger.info("======================ExampleSchedule destroyed===========================");
    }
}
