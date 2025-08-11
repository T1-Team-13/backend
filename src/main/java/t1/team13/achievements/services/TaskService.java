package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.exceptions.NotFoundException;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.repositories.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id = " + id + " не найдена"));
    }
}
