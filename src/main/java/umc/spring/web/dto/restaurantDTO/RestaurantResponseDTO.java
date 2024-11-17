package umc.spring.web.dto.restaurantDTO;

import lombok.*;

import java.time.LocalDateTime;

public class RestaurantResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRestaurantResponseDTO {
        private Long id;
        private String name;
        private String address;
        private LocalDateTime createdAt;
    }
}
