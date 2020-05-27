package ru.itis.javalabmessagequeue;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.itis.javalabmessagequeue.models.Queue;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class QueueContextRepository {

    private static Map<String, Queue> queueMap;

    public QueueContextRepository() {
        queueMap = new HashMap<>();
    }

    public void add(Queue queue) {
        queueMap.put(queue.getName(), queue);
    }

    public Queue findByName(String queueName) {
        return queueMap.get(queueName);
    }

    public boolean contains(String queueName) {
        return queueMap.containsKey(queueName);
    }

}
