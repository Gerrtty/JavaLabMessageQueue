package ru.itis.javalabmessagequeue;

import lombok.Data;

@Data
public class Producer {

    private String queueName;

    @Override
    public int hashCode() {
        return queueName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Producer && ((Producer) o).queueName.equals(queueName);
    }

}
