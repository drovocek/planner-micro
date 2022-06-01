package edu.volkov.micro.planner.users.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@EnableBinding(TodoBinding.class)
public class MessageProducer {

    private final TodoBinding todoBinding;

    public void newUserAction(Long userId) {
        Message<Long> message = MessageBuilder.withPayload(userId).build();

        this.todoBinding.todoOutputChannel().send(message);
    }
}
