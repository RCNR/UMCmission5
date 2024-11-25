package umc.spring.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.reviewDTO.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO dto, Restaurant restaurant, Member member) {

        return Review.builder()
                .content(dto.getContent())
                .score(dto.getScore())
                .restaurant(restaurant)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResponseDTO toCreateReviewResponseDTO(Review review) {

        return ReviewResponseDTO.CreateReviewResponseDTO.builder()
                .review_id(review.getId())
                .content(review.getContent())
                .score(review.getScore())
                .restaurant_id(review.getRestaurant().getId())
                .member_id(review.getMember().getId())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        log.info(review.getMember().getName());
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reivewList(reviewPreviewDTOList)
                .build();
    }
}
