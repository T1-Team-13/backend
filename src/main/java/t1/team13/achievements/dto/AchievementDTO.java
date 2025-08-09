package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "Сущность `Достижение`")
@Data
public class AchievementDTO {

    @Schema(description = "id достижения")
    private UUID id;

    @Schema(description = "название достижения")
    private String title;

    @Schema(description = "описание достижения")
    private String description;

    @Schema(description = "время получения достижения")
    private LocalDateTime completedAt;

    @Schema(description = "получено ли достижение")
    private boolean isCompleted;

    @Schema(description = "требуемый прогресс для получения достижения")
    private int requiredProgress;

    @Schema(description = "текущий прогресс")
    private int currentProgress;

    @Schema(description = "категории, к которым относится это достижение")
    private List<CategoryDTO> categories;

    @Schema(description = "конкретные задачи, которые нужно выполнить, чтобы получить это достижение")
    private List<SpecificTaskDTO> specificTasks;
}
