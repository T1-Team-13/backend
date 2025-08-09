package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Schema(description = "Зачисление активности")
@Data
public class TaskExecution {

    @Schema(description = "id пользователя")
    private UUID userId;

    @Schema(description = "id активности")
    private UUID taskId;

    @Schema(description = "Количество прогресса, которое нужно прибавить")
    private int numberOfPoints;
}
