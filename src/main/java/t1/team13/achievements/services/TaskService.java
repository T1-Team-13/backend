package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.exceptions.NotFoundException;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserTask;
import t1.team13.achievements.repositories.TaskRepository;
import t1.team13.achievements.repositories.UserTaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserTaskRepository userTaskRepository;

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

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id = " + id + " не найдена"));
    }
}
