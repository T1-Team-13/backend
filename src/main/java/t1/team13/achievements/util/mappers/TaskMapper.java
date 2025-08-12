package t1.team13.achievements.util.mappers;

import org.springframework.stereotype.Component;
import t1.team13.achievements.dto.CommonTaskDTO;
import t1.team13.achievements.dto.SpecificTaskDTO;
import t1.team13.achievements.dto.UserTaskDTO;
import t1.team13.achievements.models.AchievementTask;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.models.UserTask;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {
    public CommonTaskDTO mapToCommon(Task task) {
        CommonTaskDTO dto = new CommonTaskDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        return dto;
    }

    public List<CommonTaskDTO> mapToCommon(List<Task> tasks) {
        return tasks.stream()
                .map(this::mapToCommon)
                .toList();
    }

    public List<SpecificTaskDTO> mapToSpecificTaskDTO(List<AchievementTask> achievementTasks) {
        List<SpecificTaskDTO> specificTaskDTOS = new ArrayList<>();
        for (AchievementTask achievementTask : achievementTasks) {
            SpecificTaskDTO taskDTO = new SpecificTaskDTO();
            taskDTO.setId(achievementTask.getTask().getId());
            taskDTO.setName(achievementTask.getTask().getName());
            taskDTO.setDescription(achievementTask.getTask().getDescription());
            taskDTO.setRequiredProgress(achievementTask.getRequiredProgress());
            specificTaskDTOS.add(taskDTO);
        }
        return specificTaskDTOS;
    }

    public UserTaskDTO mapToUserTaskDTO(UserTask userTask) {
        UserTaskDTO dto = new UserTaskDTO();
        dto.setId(userTask.getTask().getId());
        dto.setName(userTask.getTask().getName());
        dto.setDescription(userTask.getTask().getDescription());
        dto.setCurrentProgress(userTask.getCurrentProgress());
        return dto;
    }

    public List<UserTaskDTO> mapToUserTaskDTO(List<UserTask> userTasks) {
        return userTasks.stream()
                .map(this::mapToUserTaskDTO)
                .toList();
    }
}
