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
import java.util.Optional;

@Component
public class AchievementMapper {
    public AchievementDTO mapToAchievementDTO(
            Achievement achievement,
            Optional<UserAchievement> userAchievement,
            List<SpecificTaskDTO> specificTaskDTOS,
            List<CategoryDTO> categoryDTOS,
            ProgressResult progress
    ) {
        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setId(achievement.getId());
        achievementDTO.setTitle(achievement.getTitle());
        achievementDTO.setDescription(achievement.getDescription());
        achievementDTO.setSpecificTasks(specificTaskDTOS);
        achievementDTO.setCategories(categoryDTOS);
        achievementDTO.setCurrentProgress(progress.getCurrent());
        achievementDTO.setRequiredProgress(progress.getRequired());

        if (userAchievement.isPresent()) {
            achievementDTO.setCompleted(true);
            achievementDTO.setCompletedAt(userAchievement.get().getCompletedAt());
        } else {
            achievementDTO.setCompleted(false);
            achievementDTO.setCompletedAt(null);
        }

        String imageUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(achievement.getImagePath())
                .toUriString();
        achievementDTO.setImageUrl(imageUrl);

        return achievementDTO;
    }
}
