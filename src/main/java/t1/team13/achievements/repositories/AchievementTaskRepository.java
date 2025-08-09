package t1.team13.achievements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.AchievementTask;
import t1.team13.achievements.models.Task;

import java.util.List;
import java.util.UUID;

@Repository
public interface AchievementTaskRepository extends JpaRepository<AchievementTask, UUID> {
    List<AchievementTask> findByAchievement(Achievement achievement);
    List<AchievementTask> findByAchievementAndTask(Achievement achievement, Task task);
}
