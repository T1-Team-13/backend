package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.CommonTaskDTO;
import t1.team13.achievements.dto.TaskExecution;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.services.TaskService;
import t1.team13.achievements.util.ErrorResponse;
import t1.team13.achievements.util.TaskMapper;

import java.util.List;
import java.util.UUID;

@Tag(name = "Контроллер задач/активностей")
@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Operation(summary = "Получить все общие задачи")
    @GetMapping
    public List<CommonTaskDTO> getTasks() {
        return taskMapper.mapToCommon(taskService.findAll());
    }

    @Operation(summary = "Получить общую задачу по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "задача не найдена",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{taskId}")
    public CommonTaskDTO getTask(@PathVariable String taskId) {
        Task task = taskService.findById(UUID.fromString(taskId));
        return taskMapper.mapToCommon(task);
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
    @PostMapping
    public void addTaskExecution(@RequestBody TaskExecution taskExecution) {

    }
}
