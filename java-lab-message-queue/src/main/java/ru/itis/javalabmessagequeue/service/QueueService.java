package ru.itis.javalabmessagequeue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabmessagequeue.models.Queue;
import ru.itis.javalabmessagequeue.models.Task;
import ru.itis.javalabmessagequeue.repositories.QueueRepository;
import ru.itis.javalabmessagequeue.repositories.TasksRepository;

import java.util.Optional;

@Service
public class QueueService {

    private final QueueRepository queueRepository;
    private final TasksRepository tasksRepository;

    @Autowired
    public QueueService(QueueRepository queueRepository, TasksRepository tasksRepository) {
        this.queueRepository = queueRepository;
        this.tasksRepository = tasksRepository;
    }

    public Task getTask(String queueName) {
        Optional<Task> task = tasksRepository.findOneByQueueNameOrderByCreatedTime(new Queue());

        if(task.isPresent()) {
            return task.get();
        }

        else throw new IllegalArgumentException("No queue with this name");
    }

    public void createQueue(String name) {
        queueRepository.save(new Queue(name));
    }

    public boolean isExists(String name) {
        return queueRepository.findByName(name).isPresent();
    }
}
