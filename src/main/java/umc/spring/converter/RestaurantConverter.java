package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.restaurantDTO.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO.CreateRestaurantDTO dto, Region region) {
        return Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(dto.getScore())
                .region(region)
                .build();
    }

    public static RestaurantResponseDTO.CreateRestaurantResponseDTO toCreateRestaurantResponseDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.CreateRestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .address(restaurant.getAddress())
                .name(restaurant.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
