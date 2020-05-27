package ru.itis.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {
    private JlmqConnector connector;
    private MessageToQueue messageToQueue;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Consumer(JlmqConnector connector) {
        this.connector = connector;
    }

    public void toQueue(String queueName) {
        try {
            send(objectMapper
                    .writeValueAsString(MessageToQueue.builder()
                            .command("subscribe")
                            .queueName(queueName)
                            .build()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        connector.getSession().getAsyncRemote().sendText(message);
    }
}
