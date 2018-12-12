package com.ykkj.weiyi.socket;

import cn.hutool.core.io.file.FileReader;
import org.apache.kafka.clients.producer.*;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class MyProducer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Boolean isAsync;
    private List<String> result;
    private static boolean isWH = true;

    public MyProducer(String topic, Boolean isAsync) {
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.47.128:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<Integer, String>(prop);
        this.topic = topic;
        this.isAsync = isAsync;

        FileReader fileReader = new FileReader("demo15.json");
        result = fileReader.readLines();
    }

    public void run() {
        int messageNo = 1;

        int start = 0;
        int step = 5000;
        int stepVal = 5000;
        while (isWH) {
            String messageStr = "Message_" + messageNo;
            for(int i=start;i<step;i++){
                System.out.println(result.get(i));
                messageStr = result.get(i);
                long startTime = System.currentTimeMillis();
                if (isAsync) {
                    producer.send(new ProducerRecord<Integer, String>(topic, messageNo, messageStr), new DemoCallback(startTime, messageNo, messageStr));
                } else {
                    try {
                        producer.send(new ProducerRecord<Integer, String>(topic, messageNo, messageStr)).get();
                        System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                ++messageNo;
            }
//            isWH = false;
            start = step;
            step = step + stepVal;
            if(step >= result.size()){
                step = result.size();
            }
            if(start == result.size()){
                start = 0;
                step = stepVal;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");

        MyProducer producerThread = new MyProducer("test.topic", isAsync);
        producerThread.start();
    }

    public static void startKafka(){
        isWH = true;
        boolean isAsync = true;
        MyProducer producerThread = new MyProducer("GpsLocations", isAsync);
        producerThread.start();
    }
    public static void stopKafka(){
        isWH = false;
    }

    public void getDatas(){
        FileReader fileReader = new FileReader("static.properties");
        String result = fileReader.readString();
        System.out.println(result);
    }
}

class DemoCallback implements Callback {
    private final long startTime;
    private final int key;
    private final String message;

    public DemoCallback(long startTime, int key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                    "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                            "), " +
                            "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}
