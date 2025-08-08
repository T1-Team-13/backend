package t1.team13.achievements.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "achievements")
@Data
public class Achievement {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String description;

    @Column(name = "unlocked_image_path")
    private String unlockedImagePath;

    @Column(name = "locked_image_path")
    private String lockedImagePath;

    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAchievement> userAchievements;

    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AchievementTask> achievementTasks;

    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AchievementCategory> achievementCategories;
}
