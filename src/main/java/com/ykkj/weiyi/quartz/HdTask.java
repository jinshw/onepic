package com.ykkj.weiyi.quartz;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//@Lazy(false)
public class HdTask {

//    @Scheduled(cron = "0/5 * *  * * ? ")
    public void getDatas() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(date));
        System.out.println("1231231");
    }
}
