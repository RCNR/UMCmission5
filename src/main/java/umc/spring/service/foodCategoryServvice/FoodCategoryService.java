package umc.spring.service.foodCategoryServvice;

import java.util.List;

public interface FoodCategoryService {

    boolean existsAllByIds(List<Long> ids);
}
