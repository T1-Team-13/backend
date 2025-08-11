package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import t1.team13.achievements.dto.AchievementDTO;
import t1.team13.achievements.services.AchievementDTOService;
import t1.team13.achievements.util.ErrorResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Контроллер достижений")
@RestController
@RequestMapping("/api/v1/users/{userId}/achievements")
@AllArgsConstructor
public class UserAchievementController {
    private final AchievementDTOService achievementDTOService;

    @Operation(summary = "Получить конкретное достижение пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь и/или достижение не найдено",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{achievementId}")
    public AchievementDTO getAchievement(@PathVariable String userId, @PathVariable String achievementId) {
        return achievementDTOService.getAchievementDto(UUID.fromString(userId), UUID.fromString(achievementId));
    }

    @Operation(summary = "Получить все достижения пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь не найден",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping
    public List<AchievementDTO> getAchievements(@PathVariable String userId) {
        return achievementDTOService.getAllAchievementDTOS(UUID.fromString(userId));
    }
}
