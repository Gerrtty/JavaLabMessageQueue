package ru.itis.sdk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sdk.Consumer;
import ru.itis.sdk.JlmqConnector;
import ru.itis.sdk.Producer;

import javax.websocket.*;

@RestController
@ClientEndpoint
public class TestController {

    @GetMapping("/test")
    public void t() {

        JlmqConnector connector = new JlmqConnector.Connector().port("9086").connect();

        Producer producer = connector.producer();
        Consumer consumer = connector.consumer();

        consumer.toQueue("new_queue");
    }

}
