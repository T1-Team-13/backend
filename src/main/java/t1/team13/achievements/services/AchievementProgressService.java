package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.models.AchievementTask;
import t1.team13.achievements.models.User;
import t1.team13.achievements.util.ProgressResult;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AchievementProgressService {
    private final TaskService taskService;

    public ProgressResult getProgress(User user, List<AchievementTask> achievementTasks) {
        Map<UUID, Integer> taskProgressMap = taskService.findTasksProgressByUser(user);
        int currentProgress = 0, requiredProgress;

        if (achievementTasks.size() == 1) {
            requiredProgress = achievementTasks.getFirst().getRequiredProgress();
            currentProgress = taskProgressMap.get(achievementTasks.getFirst().getTask().getId());
        } else {
            requiredProgress = achievementTasks.size();
            for (AchievementTask achievementTask : achievementTasks) {
                int currentTaskProgress = taskProgressMap.get(achievementTask.getTask().getId());
                if (currentTaskProgress >= achievementTask.getRequiredProgress()) {
                    currentProgress++;
                }
            }
        }

        return new ProgressResult(currentProgress, requiredProgress);
    }
}
