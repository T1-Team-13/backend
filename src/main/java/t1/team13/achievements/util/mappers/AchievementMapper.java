package t1.team13.achievements.util.mappers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.dto.CategoryDTO;
import t1.team13.achievements.dto.SpecificTaskDTO;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.UserAchievement;
import t1.team13.achievements.util.ProgressResult;

import java.util.List;

@Component
public class AchievementMapper {
    public AchievementDTO mapToAchievementDTO(
            Achievement achievement,
            UserAchievement userAchievement,
            List<SpecificTaskDTO> specificTaskDTOS,
            List<CategoryDTO> categoryDTOS,
            ProgressResult progress
    ) {
        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(achievement.getId());
        achievementDTO.setTitle(achievement.getTitle());
        achievementDTO.setDescription(achievement.getDescription());
        achievementDTO.setCompleted(userAchievement.isCompleted());
        achievementDTO.setCompletedAt(userAchievement.getCompletedAt());
        achievementDTO.setSpecificTasks(specificTaskDTOS);
        achievementDTO.setCategories(categoryDTOS);
        achievementDTO.setCurrentProgress(progress.getCurrent());
        achievementDTO.setRequiredProgress(progress.getRequired());

        String lockedImageUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(achievement.getLockedImagePath())
                .toUriString();
        String unlockedImageUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(achievement.getUnlockedImagePath())
                .toUriString();

        achievementDTO.setLockedImageUrl(lockedImageUrl);
        achievementDTO.setUnlockedImageUrl(unlockedImageUrl);

        return achievementDTO;
    }
}
