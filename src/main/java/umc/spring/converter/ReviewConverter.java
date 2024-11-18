package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.reviewDTO.ReviewResponseDTO;

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
}
