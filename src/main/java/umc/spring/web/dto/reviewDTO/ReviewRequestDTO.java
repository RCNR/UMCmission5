package umc.spring.web.dto.reviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistRestaurant;

import java.time.LocalDate;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {

        @NotNull
        private Float score;

        @NotBlank
        private String content;

        @ExistRestaurant
        private Long restaurantId;

        @NotNull
        private Long memberId;
    }
}
