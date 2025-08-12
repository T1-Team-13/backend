package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import t1.team13.achievements.exceptions.NotFoundException;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserTask;
import t1.team13.achievements.repositories.UserTaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final UserService userService;
    private final TaskService taskService;

    public Map<UUID, Integer> findTasksProgressByUser(User user) {
        List<UserTask> userTasks = userTaskRepository.findByUser(user);
        Map<UUID, Integer> taskProgressMap = new HashMap<>();
        for (UserTask userTask : userTasks) {
            UUID taskId = userTask.getTask().getId();
            int currentProgress = userTask.getCurrentProgress();
            taskProgressMap.put(taskId, currentProgress);
        }
        return taskProgressMap;
    }

    public UserTask findByUserAndTask(User user, Task task) {
        return userTaskRepository.findByUserAndTask(user, task).orElseThrow(() ->
                new NotFoundException("Задача с id = " + task.getId() + " у пользователя с id = " + user.getId() + " не найдена")
        );
    }

    public UserTask findByUserIdAndTaskId(String userId, String taskId) {
        User user = userService.findById(UUID.fromString(userId));
        Task task = taskService.findById(UUID.fromString(taskId));
        return findByUserAndTask(user, task);
    }

    public List<UserTask> findByUserId(String userId) {
        User user = userService.findById(UUID.fromString(userId));
        return userTaskRepository.findByUser(user);
    }
}
