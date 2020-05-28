package ru.itis.javalabmessagequeue;

import lombok.Data;

@Data
public class Consumer {

    private String queueName;

    @Override
    public int hashCode() {
        return queueName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Consumer && ((Consumer) o).queueName.equals(queueName);
    }

}
