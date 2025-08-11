package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.exceptions.NotFoundException;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserAchievement;
import t1.team13.achievements.repositories.AchievementRepository;
import t1.team13.achievements.repositories.UserAchievementRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AchievementService {
    private final AchievementRepository achievementRepository;

    public Achievement findById(UUID id) {
        return achievementRepository.findById(id).orElseThrow(() -> new NotFoundException("Достижение с id = " + id + " не найдено"));
    }
}
