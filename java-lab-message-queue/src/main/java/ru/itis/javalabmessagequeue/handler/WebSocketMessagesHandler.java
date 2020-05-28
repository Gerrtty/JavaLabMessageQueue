package ru.itis.javalabmessagequeue.handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.javalabmessagequeue.Consumer;
import ru.itis.javalabmessagequeue.MessageToQueue;
import ru.itis.javalabmessagequeue.Producer;
import ru.itis.javalabmessagequeue.service.QueueService;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@EnableWebSocket
@Component
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<Queue, WebSocketSession> activeQueues = new HashMap<>();

    // тут будут лежать все активные консьюмеры - первый аргумент это имя очереди
    private static final Map<String, WebSocketSession> consumers = new HashMap<>();

    // а тут все активные продьюсеры
    private static final Map<String, WebSocketSession> producers = new HashMap<>();

    private final ObjectMapper objectMapper;
    private final QueueService queueService;

    public WebSocketMessagesHandler(ObjectMapper objectMapper, QueueService queueService) {
        this.objectMapper = objectMapper;
        this.queueService = queueService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("New message from websocket");
        MessageToQueue messageToQueue = objectMapper.readValue(message.getPayload(), MessageToQueue.class);
        System.out.println(messageToQueue);

        session.sendMessage(new TextMessage("subscribed"));

        if(messageToQueue.getCommand().equals("subscribe")) {

            if(!queueService.isExists(messageToQueue.getQueueName())) {
                session.sendMessage(new TextMessage("No such queue"));
            }

            else {

                if(!producers.containsKey(messageToQueue.getQueueName())) {
                    producers.put(messageToQueue.getQueueName(), session);
                }

            }
        }

        if(messageToQueue.getCommand().equals("send")) {

        }

        if(messageToQueue.getCommand().equals("")) {

        }
    }

}

