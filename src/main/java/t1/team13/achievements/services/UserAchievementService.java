package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserAchievement;
import t1.team13.achievements.repositories.UserAchievementRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAchievementService {
    private final UserAchievementRepository userAchievementRepository;

    public Optional<UserAchievement> findByAchievementAndUser(Achievement achievement, User user) {
        return userAchievementRepository.findByAchievementAndUser(achievement, user);
    }

    public List<UserAchievement> findByUser(User user) {
        return userAchievementRepository.findByUser(user);
    }

    public UserAchievement save(UserAchievement userAchievement) {
        return userAchievementRepository.save(userAchievement);
    }

    public void delete(UserAchievement userAchievement) {
        userAchievementRepository.delete(userAchievement);
    }
}
