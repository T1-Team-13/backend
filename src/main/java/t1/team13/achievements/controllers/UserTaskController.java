package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.TaskExecution;
import t1.team13.achievements.dto.UserTaskDTO;
import t1.team13.achievements.services.AchievementProgressService;
import t1.team13.achievements.services.UserTaskService;
import t1.team13.achievements.util.ErrorResponse;
import t1.team13.achievements.util.mappers.TaskMapper;

import java.util.List;

@Tag(name = "Контроллер задач/активностей пользователя")
@RestController
@RequestMapping("/api/v1/users/{userId}/tasks")
@AllArgsConstructor
public class UserTaskController {
    private final UserTaskService userTaskService;
    private final AchievementProgressService progressService;
    private final TaskMapper taskMapper;

    @Operation(summary = "Получить задачу пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь и/или достижение не найдено",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{taskId}")
    public UserTaskDTO getTask(@PathVariable String userId, @PathVariable String taskId) {
        return taskMapper.mapToUserTaskDTO(userTaskService.findByUserIdAndTaskId(userId, taskId));
    }

    @Operation(summary = "Получить все задачи пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь не найден",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping
    public List<UserTaskDTO> getTasks(@PathVariable String userId) {
        return taskMapper.mapToUserTaskDTO(userTaskService.findByUserId(userId));
    }

    @Operation(summary = "Зачислить пользователю некоторую активность")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь и/или задача не найдена",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PatchMapping
    public void addTaskExecution(@RequestBody TaskExecution taskExecution, @PathVariable String userId) {
        progressService.updateProgress(taskExecution, userId);
    }
}
