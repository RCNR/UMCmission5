package umc.spring.service.storeService.query;

import umc.spring.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);

    List<Restaurant> findRestaurantByNameAndScore(String name, Float score);
}
