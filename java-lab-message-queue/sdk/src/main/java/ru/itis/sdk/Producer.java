package ru.itis.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producer<T> {

    private String command;
    private String queueName;
    private T body;

    private JlmqConnector connector;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Producer(JlmqConnector jlmqConnector) {
        this.connector = jlmqConnector;
    }

}
