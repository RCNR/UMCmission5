package umc.spring.service.storeService;

import umc.spring.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Restaurant> findRestaurant(Long id);

    List<Restaurant> findRestaurantByNameAndScore(String name, Float score);
}
