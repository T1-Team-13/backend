package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.exceptions.NotFoundException;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserAchievement;
import t1.team13.achievements.repositories.UserAchievementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserAchievementService {
    private final UserAchievementRepository userAchievementRepository;

    public UserAchievement findByAchievementAndUser(Achievement achievement, User user) {
        return userAchievementRepository.findByAchievementAndUser(achievement, user).orElseThrow(() ->
                new NotFoundException("Достижение с id = " + achievement.getId() + " у пользователя с id = " + user.getId() + " не найдено")
        );
    }

    public List<UserAchievement> findByUser(User user) {
        return userAchievementRepository.findByUser(user);
    }
}
