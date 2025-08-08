package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.dto.TaskExecution;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/achievements")
@Tag(name = "Контроллер достижений")
public class UserAchievementController {

    @Operation(summary = "Получить конкретное достижение пользователя")
    @GetMapping("/{achievementId}")
    public AchievementDTO getAchievement(@PathVariable String achievementId, @PathVariable String userId) {
        return null;
    }

    @Operation(summary = "Получить все достижения пользователя")
    @GetMapping
    public List<AchievementDTO> getAchievements(@PathVariable String userId) {
        return null;
    }

    @Operation(summary = "Зачислить пользователю некоторую активность")
    @PostMapping
    public String addTaskExecution(@RequestBody TaskExecution taskExecution, @PathVariable String userId) {
        return null;
    }
}
