package ru.itis.javalabmessagequeue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageToQueue<T> {

    private String command;
    private String queueName;
    private String messageId;
    private T body;
}
