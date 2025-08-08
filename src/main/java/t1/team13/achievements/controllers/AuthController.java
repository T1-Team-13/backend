package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.team13.achievements.dto.LoginDTO;
import t1.team13.achievements.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Контроллер аутентификации")
public class AuthController {

    @Operation(
            summary = "Вход в систему",
            description = "Возвращает сущность `Пользователь`"
    )
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO dto) {
        return null;
    }
}
