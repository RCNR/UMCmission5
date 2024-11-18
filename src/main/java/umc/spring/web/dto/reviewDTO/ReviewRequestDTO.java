package umc.spring.web.dto.reviewDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {

        @NotBlank
        private Float score;

        @NotBlank
        private String content;

        @ExistRestaurant
        private Long restaurantId;

        @NotBlank
        private Long memberId;
    }
}
