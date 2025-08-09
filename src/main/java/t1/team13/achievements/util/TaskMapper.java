package t1.team13.achievements.util;

import org.springframework.stereotype.Component;
import t1.team13.achievements.dto.CommonTaskDTO;
import t1.team13.achievements.dto.UserDTO;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.models.User;

import java.util.List;

@Component
public class TaskMapper {
    public CommonTaskDTO mapToCommon(Task task) {
        CommonTaskDTO dto = new CommonTaskDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        return dto;
    }

    public List<CommonTaskDTO> mapToCommon(List<Task> tasks) {
        return tasks.stream()
                .map(this::mapToCommon)
                .toList();
    }
}
