package umc.spring.service.storeService.command;

import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.restaurantDTO.RestaurantRequestDTO;

public interface RestaurantCommandService {

    Restaurant createRestaurant(RestaurantRequestDTO.CreateRestaurantDTO dto);
}
