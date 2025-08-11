package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.dto.CategoryDTO;
import t1.team13.achievements.dto.SpecificTaskDTO;
import t1.team13.achievements.models.*;
import t1.team13.achievements.util.ProgressResult;
import t1.team13.achievements.util.mappers.AchievementMapper;
import t1.team13.achievements.util.mappers.CategoryMapper;
import t1.team13.achievements.util.mappers.TaskMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AchievementDTOService {
    private final UserService userService;
    private final AchievementService achievementService;
    private final CategoryService categoryService;
    private final AchievementProgressService achievementProgressService;
    private final CategoryMapper categoryMapper;
    private final TaskMapper taskMapper;
    private final AchievementMapper achievementMapper;

    public AchievementDTO getAchievementDto(UUID userId, UUID achievementId) {
        User user = userService.findById(userId);
        Achievement achievement = achievementService.findById(achievementId);
        UserAchievement userAchievement = achievementService.findByAchievementAndUser(achievement, user);
        List<AchievementTask> achievementTasks = achievement.getAchievementTasks();
        List<Category> categories = categoryService.findByAchievement(achievement);
        List<CategoryDTO> categoryDTOS = categoryMapper.map(categories);
        List<SpecificTaskDTO> specificTaskDTOS = taskMapper.mapToSpecificTaskDTO(achievementTasks);
        ProgressResult progress = achievementProgressService.getProgress(user, achievementTasks);

        return achievementMapper.mapToAchievementDTO(
                achievement,
                userAchievement,
                specificTaskDTOS,
                categoryDTOS,
                progress
        );
    }

    public List<AchievementDTO> getAllAchievementDTOS(UUID userId) {
        User user = userService.findById(userId);
        List<UserAchievement> userAchievements = achievementService.findByUser(user);

        return userAchievements.stream()
                .map(userAchievement -> getAchievementDto(userId, userAchievement.getAchievement().getId()))
                .toList();
    }
}
