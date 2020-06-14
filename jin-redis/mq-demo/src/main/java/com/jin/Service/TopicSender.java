package com.jin.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class TopicSender implements RabbitTemplate.ConfirmCallback {


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public TopicSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void send2() {
        for (int i = 0; i < 1000; i++) {
            String context = "hi, i am messages " + i;
            System.out.println("Sender : " + context);
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            System.out.println("callbackSender UUID: " + correlationData.getId());
            this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context, correlationData);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("confirm: " + correlationData.getId() + ",s=" + s + ",b:" + b);
    }
}
