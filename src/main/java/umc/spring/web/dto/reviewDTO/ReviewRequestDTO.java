package umc.spring.web.dto.reviewDTO;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {

        private Float score;
        private String content;
        private Long restaurantId;
        private Long memberId;
    }
}
