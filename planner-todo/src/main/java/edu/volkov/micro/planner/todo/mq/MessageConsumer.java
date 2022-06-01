package edu.volkov.micro.planner.todo.mq;

import edu.volkov.micro.planner.todo.service.TestDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(TodoBinding.class)
@RequiredArgsConstructor
public class MessageConsumer {

    private final TestDataService testDataService;

    @StreamListener(target = TodoBinding.INPUT_CHANNEL)
    public void initTestData(Long userId) {
        this.testDataService.initTestData(userId);
    }
}
