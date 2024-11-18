package umc.spring.web.dto.restaurantDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class CreateRestaurantDTO {
        @NotBlank
        private String name;

        @NotBlank
        private String address;

        private Float score;

        @NotNull
        private Long regionId;
    }
}
