package umc.spring.service.reviewService.query;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {

    Page<Review> getMyReview(Long restaurantId, Integer page);
}
