package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.team13.achievements.dto.LoginDTO;
import t1.team13.achievements.dto.UserDTO;
import t1.team13.achievements.models.User;
import t1.team13.achievements.services.AuthService;
import t1.team13.achievements.util.ErrorResponse;
import t1.team13.achievements.util.mappers.UserMapper;

@Tag(name = "Контроллер аутентификации")
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserMapper userMapper;

    @Operation(
            summary = "Вход в систему",
            description = "Возвращает сущность `Пользователь`"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "401",
                    description = "неверная почта или пароль",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO dto) {
        User user = authService.login(dto);
        return userMapper.map(user);
    }
}
