package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.services.AchievementDTOBuilder;

import java.util.List;
import java.util.UUID;

@Tag(name = "Контроллер достижений")
@RestController
@RequestMapping("/api/v1/users/{userId}/achievements")
@AllArgsConstructor
public class UserAchievementController {
    private final AchievementDTOBuilder achievementDTOBuilder;

    @Operation(summary = "Получить конкретное достижение пользователя")
    @GetMapping("/{achievementId}")
    public AchievementDTO getAchievement(@PathVariable String userId, @PathVariable String achievementId) {
        return achievementDTOBuilder.getAchievementDto(UUID.fromString(userId), UUID.fromString(achievementId));
    }

    @Operation(summary = "Получить все достижения пользователя")
    @GetMapping
    public List<AchievementDTO> getAchievements(@PathVariable String userId) {
        return achievementDTOBuilder.getAllAchievementDTOS(UUID.fromString(userId));
    }
}
