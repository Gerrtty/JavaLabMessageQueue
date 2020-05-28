package ru.itis.javalabmessagequeue.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "queue")
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "queueName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Queue(String name) {
        this.name = name;
    }
}
