package umc.spring.web.dto.reviewDTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        String ownerNickname; // 만약 사용자 정보가 닉네임 말고도 더 많다면 그 자체로 DTO 구성하여 감싸는 게 좋다
        // ex) MemberInfoDTO memberinfo;
        Float score;
        String body;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO {

        List<ReviewPreviewDTO> reivewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
