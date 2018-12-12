package com.ykkj.weiyi.socket;

public class RunThread {
    public RunThread() {
        ConsumerKafka kafka = new ConsumerKafka();
        kafka.start();
    }
}
