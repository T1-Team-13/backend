package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Сущность `Пользователь`")
@Data
public class UserDTO {

    @Schema(description = "id пользователя")
    private UUID id;

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Роль пользователя: `ROLE_USER` или `ROLE_ADMIN`")
    private String role;

    @Schema(description = "Дата и время регистрации")
    private LocalDateTime registrationDate;

    @Schema(description = "URL аватарки пользователя", example = "http://localhost:8080/uploads/images/avatars/{userId}.jpg")
    private String imageUrl;
}
