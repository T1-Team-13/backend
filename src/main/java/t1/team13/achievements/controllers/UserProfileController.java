package t1.team13.achievements.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.team13.achievements.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Контроллер профилей пользователей")
public class UserProfileController {

    @Operation(summary = "Получить пользователя по id")
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable String userId) {
        UserDTO dto = new UserDTO();
        dto.setFirstName("Иван");
        dto.setLastName("Иванов");
        dto.setRole("ROLE_USER");
        dto.setRegistrationDate(LocalDateTime.now());
        System.out.println(dto.getRegistrationDate());
        return dto;
    }

    @Operation(summary = "Получить всех пользователей")
    @GetMapping
    public List<UserDTO> getUsers() {
        return null;
    }
}
