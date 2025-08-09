package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.dto.CategoryDTO;
import t1.team13.achievements.dto.SpecificTaskDTO;
import t1.team13.achievements.models.*;
import t1.team13.achievements.util.CategoryMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AchievementDTOBuilder {
    private final UserService userService;
    private final AchievementService achievementService;
    private final TaskService taskService;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public AchievementDTO getAchievementDto(UUID userId, UUID achievementId) {
        User user = userService.findById(userId);
        Achievement achievement = achievementService.findById(achievementId);
        UserAchievement userAchievement = achievementService.findByAchievementAndUser(achievement, user);

        List<AchievementTask> achievementTasks = achievement.getAchievementTasks();
        List<Category> categories = categoryService.findByAchievement(achievement);
        List<CategoryDTO> categoryDTOS = categoryMapper.map(categories);
        List<SpecificTaskDTO> specificTaskDTOS = mapToSpecificTaskDTO(achievementTasks);

        int currentProgress = 0, requiredProgress;
        if (achievementTasks.size() == 1) {
            requiredProgress = achievementTasks.getFirst().getRequiredProgress();
            currentProgress = taskService.findByUserAndTask(user, achievementTasks.getFirst().getTask()).getCurrentProgress();
        } else {
            requiredProgress = achievementTasks.size();
            for (AchievementTask achievementTask : achievementTasks) {
                int currentTaskProgress = taskService.findByUserAndTask(user, achievementTask.getTask()).getCurrentProgress();
                if (currentTaskProgress >= achievementTask.getRequiredProgress()) {
                    currentProgress++;
                }
            }
        }

        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(achievementId);
        achievementDTO.setTitle(achievement.getTitle());
        achievementDTO.setDescription(achievement.getDescription());
        achievementDTO.setCompleted(userAchievement.isCompleted());
        achievementDTO.setCompletedAt(userAchievement.getCompletedAt());
        achievementDTO.setSpecificTasks(specificTaskDTOS);
        achievementDTO.setCategories(categoryDTOS);
        achievementDTO.setCurrentProgress(currentProgress);
        achievementDTO.setRequiredProgress(requiredProgress);

        return achievementDTO;
    }

    public List<AchievementDTO> getAllAchievementDTOS(UUID userId) {
        User user = userService.findById(userId);
        List<UserAchievement> userAchievements = achievementService.findByUser(user);

        return userAchievements.stream()
                .map(userAchievement -> getAchievementDto(userId, userAchievement.getAchievement().getId()))
                .toList();
    }

    private List<SpecificTaskDTO> mapToSpecificTaskDTO(List<AchievementTask> achievementTasks) {
        List<SpecificTaskDTO> specificTaskDTOS = new ArrayList<>();
        for (AchievementTask achievementTask : achievementTasks) {
            SpecificTaskDTO taskDTO = new SpecificTaskDTO();
            taskDTO.setId(achievementTask.getTask().getId());
            taskDTO.setDescription(achievementTask.getTask().getDescription());
            taskDTO.setRequiredProgress(achievementTask.getRequiredProgress());
            specificTaskDTOS.add(taskDTO);
        }
        return specificTaskDTOS;
    }
}
