package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.dto.LoginDTO;
import t1.team13.achievements.exceptions.InvalidCredentialsException;
import t1.team13.achievements.models.User;
import t1.team13.achievements.repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User login(LoginDTO dto) {
        Optional<User> optional = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optional.isEmpty()) {
            throw new InvalidCredentialsException("Неправильный логин или пароль");
        }
        return optional.get();
    }
}
