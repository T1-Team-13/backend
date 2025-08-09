package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.TaskExecution;

@Tag(name = "Контроллер активности пользователя")
@RestController
@RequestMapping("/api/v1/users/{userId}/tasks")
public class UserTaskController {

    @Operation(summary = "Зачислить пользователю некоторую активность")
    @PostMapping
    public String addTaskExecution(@RequestBody TaskExecution taskExecution, @PathVariable String userId) {
        return null;
    }
}
