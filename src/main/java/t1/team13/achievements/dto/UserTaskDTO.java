package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Schema(description = "Сущность `Задача пользователя`")
@Data
public class UserTaskDTO {

    @Schema(description = "id активности/задачи")
    private UUID id;

    @Schema(description = "название активности")
    private String name;

    @Schema(description = "описание активности")
    private String description;

    @Schema(description = "текущий прогресс этой задачи")
    private int currentProgress;
}