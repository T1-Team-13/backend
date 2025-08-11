package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Schema(description = "Сущность `Общая задача`")
@Data
public class CommonTaskDTO {

    @Schema(description = "id активности/задачи")
    private UUID id;

    @Schema(description = "название активности", example = "выступить на конференции")
    private String name;

    @Schema(description = "описание активности")
    private String description;
}
