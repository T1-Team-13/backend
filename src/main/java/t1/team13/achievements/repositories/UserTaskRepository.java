package t1.team13.achievements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.team13.achievements.models.Task;
import t1.team13.achievements.models.User;
import t1.team13.achievements.models.UserTask;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, UUID> {
    List<UserTask> findByUser(User user);
    Optional<UserTask> findByUserAndTask(User user, Task task);
}
