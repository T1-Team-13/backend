package t1.team13.achievements.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "achievement_task")
@Data
public class AchievementTask {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "required_progress")
    private int requiredProgress;
}
