package t1.team13.achievements.util.mappers;

import org.springframework.stereotype.Component;
import t1.team13.achievements.dto.CommonTaskDTO;
import t1.team13.achievements.dto.SpecificTaskDTO;
import t1.team13.achievements.models.AchievementTask;
import t1.team13.achievements.models.Task;

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
}
