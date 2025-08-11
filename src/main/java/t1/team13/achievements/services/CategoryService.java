package t1.team13.achievements.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import t1.team13.achievements.models.Achievement;
import t1.team13.achievements.models.AchievementCategory;
import t1.team13.achievements.models.Category;
import t1.team13.achievements.repositories.AchievementCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final AchievementCategoryRepository achievementCategoryRepository;

    public List<Category> findByAchievement(Achievement achievement) {
        List<AchievementCategory> achievementCategories = achievementCategoryRepository.findByAchievement(achievement);
        List<Category> categories = new ArrayList<>();
        for (AchievementCategory achievementCategory : achievementCategories) {
            categories.add(achievementCategory.getCategory());
        }
        return categories;
    }
}
