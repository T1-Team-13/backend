package t1.team13.achievements.util.mappers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import t1.team13.achievements.dto.UserDTO;
import t1.team13.achievements.models.User;

import java.util.List;

@Component
public class UserMapper {
    public UserDTO map(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPatronymic(user.getPatronymic());
        dto.setRole(user.getRole().toString());
        dto.setRegistrationDate(user.getRegistrationDate());

        String imageUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(user.getAvatarPath())
                .toUriString();
        dto.setImageUrl(imageUrl);

        return dto;
    }

    public List<UserDTO> map(List<User> users) {
        return users.stream()
                .map(this::map)
                .toList();
    }
}
