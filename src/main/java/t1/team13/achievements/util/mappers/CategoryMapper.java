package t1.team13.achievements.util.mappers;

import org.springframework.stereotype.Component;
import t1.team13.achievements.dto.CategoryDTO;
import t1.team13.achievements.models.Category;

import java.util.List;

@Component
public class CategoryMapper {
    public CategoryDTO map(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    public List<CategoryDTO> map(List<Category> categories) {
        return categories.stream()
                .map(this::map)
                .toList();
    }
}
