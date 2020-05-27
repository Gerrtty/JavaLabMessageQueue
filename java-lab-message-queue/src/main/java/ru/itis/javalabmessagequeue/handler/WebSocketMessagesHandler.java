package ru.itis.javalabmessagequeue.handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.javalabmessagequeue.MessageToQueue;
import ru.itis.javalabmessagequeue.QueueContextRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@EnableWebSocket
@Component
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<Queue, WebSocketSession> sessions = new HashMap<>();

    private final ObjectMapper objectMapper;

    public WebSocketMessagesHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("New message from websocket");
        MessageToQueue messageToQueue = objectMapper.readValue(message.getPayload(), MessageToQueue.class);
        System.out.println(messageToQueue);

        session.sendMessage(new TextMessage("subscribed"));

        if(messageToQueue.getCommand().equals("subscribe")) {
            // подписаться
        }

        if(messageToQueue.getCommand().equals("send")) {

        }

        if(messageToQueue.getCommand().equals("")) {

        }
    }

}

