package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(ReviewRequestDTO.CreateReviewDTO dto);
}
