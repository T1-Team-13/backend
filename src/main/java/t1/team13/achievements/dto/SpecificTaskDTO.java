package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Schema(description = "Сущность `Конкретная задача`")
@Data
public class SpecificTaskDTO {

    @Schema(description = "id активности")
    private UUID id;

    @Schema(description = "описание активности", example = "выступить на конференции")
    private String description;

    @Schema(description = "требуемый прогресс для выполнения этой задачи")
    private int requiredProgress;
}
