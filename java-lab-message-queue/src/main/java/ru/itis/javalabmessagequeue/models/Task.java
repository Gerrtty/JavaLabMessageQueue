package ru.itis.javalabmessagequeue.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Queue queueName;

    private String messageId;
}
