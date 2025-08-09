package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.team13.achievements.dto.UserDTO;
import t1.team13.achievements.models.User;
import t1.team13.achievements.services.UserService;
import t1.team13.achievements.util.ErrorResponse;
import t1.team13.achievements.util.UserMapper;

import java.util.List;
import java.util.UUID;

@Tag(name = "Контроллер профилей пользователей")
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserProfileController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Получить пользователя по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(
                    responseCode = "404",
                    description = "пользователь не найден",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable String userId) {
        User user = userService.findById(UUID.fromString(userId));
        return userMapper.map(user);
    }

    @Operation(summary = "Получить всех пользователей")
    @GetMapping
    public List<UserDTO> getUsers() {
        return userMapper.map(userService.findAll());
    }
}
