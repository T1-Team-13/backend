package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Schema(description = "Категория достижений")
@Data
public class CategoryDTO {

    @Schema(description = "id категории")
    private UUID id;

    @Schema(description = "Название категории")
    private String name;

    @Schema(description = "Описание категории")
    private String description;
}
