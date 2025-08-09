package t1.team13.achievements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserAchievement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAchievementRepository extends JpaRepository<UserAchievement, UUID> {
    Optional<UserAchievement> findByAchievementAndUser(Achievement achievement, User user);
    List<UserAchievement> findByUser(User user);
}
