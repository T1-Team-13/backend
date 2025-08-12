package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t1.team13.achievements.dto.TaskExecution;
import t1.team13.achievements.models.*;
import t1.team13.achievements.util.ProgressResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AchievementProgressService {
    private final TaskService taskService;
    private final UserService userService;
    private final UserTaskService userTaskService;
    private final UserAchievementService userAchievementService;
    private final AchievementService achievementService;

    public ProgressResult getAchievementProgress(User user, List<AchievementTask> achievementTasks) {
        Map<UUID, Integer> taskProgressMap = userTaskService.findTasksProgressByUser(user);
        int currentProgress = 0;
        int requiredProgress;

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

    @Transactional
    public void updateProgress(TaskExecution taskExecution, String userId) {
        User user = userService.findById(UUID.fromString(userId));
        Task task = taskService.findById(taskExecution.getTaskId());
        int numberOfPoints = taskExecution.getNumberOfPoints();

        updateTaskProgress(user, task, numberOfPoints);
        updateAchievementsProgress(user);
    }

    private void updateTaskProgress(User user, Task task, int numberOfPoints) {
        UserTask userTask = userTaskService.findByUserAndTask(user, task);
        userTask.setCurrentProgress(userTask.getCurrentProgress() + numberOfPoints);
    }

    private void updateAchievementsProgress(User user) {
        List<Achievement> achievements = achievementService.findAll();

        for (Achievement achievement : achievements) {
            List<AchievementTask> achievementTasks = achievement.getAchievementTasks();
            Optional<UserAchievement> optionalUserAchievement = userAchievementService.findByAchievementAndUser(achievement, user);
            ProgressResult progress = getAchievementProgress(user, achievementTasks);

            if (progress.getCurrent() >= progress.getRequired() && optionalUserAchievement.isEmpty()) {
                UserAchievement userAchievement = new UserAchievement();
                userAchievement.setUser(user);
                userAchievement.setAchievement(achievement);
                userAchievement.setCompletedAt(LocalDateTime.now());
                userAchievementService.save(userAchievement);
            } else if (progress.getCurrent() < progress.getRequired() && optionalUserAchievement.isPresent()) {
                UserAchievement userAchievement = optionalUserAchievement.get();
                userAchievementService.delete(userAchievement);
            }
        }
    }
}
