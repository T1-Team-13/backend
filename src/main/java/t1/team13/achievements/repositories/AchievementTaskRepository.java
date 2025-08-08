package t1.team13.achievements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.team13.achievements.models.AchievementTask;

import java.util.UUID;

@Repository
public interface AchievementTaskRepository extends JpaRepository<AchievementTask, UUID> {
}
