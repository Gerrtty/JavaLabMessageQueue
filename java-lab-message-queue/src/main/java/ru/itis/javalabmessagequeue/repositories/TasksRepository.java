package ru.itis.javalabmessagequeue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.javalabmessagequeue.models.Queue;
import ru.itis.javalabmessagequeue.models.Task;

import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
    Optional<Task> findOneByQueueNameOrderByCreatedTime(Queue queue);
}
