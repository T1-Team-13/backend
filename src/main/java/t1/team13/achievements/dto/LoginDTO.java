package t1.team13.achievements.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Данные для входа")
@Data
public class LoginDTO {
    private String email;
    private String password;
}
