package umc.spring.web.dto.restaurantDTO;

import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class CreateRestaurantDTO {
        private String name;
        private String address;
        private Float score;
        private Long regionId;
    }
}
