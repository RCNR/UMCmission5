package umc.spring.service.foodCategoryServvice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existsAllByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
