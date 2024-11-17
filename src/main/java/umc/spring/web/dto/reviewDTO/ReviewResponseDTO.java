package umc.spring.web.dto.reviewDTO;

import lombok.*;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateReviewResponseDTO {

        private Long review_id;
        private Float score;
        private String content;
        private Long restaurant_id;
        private Long member_id;
    }
}
