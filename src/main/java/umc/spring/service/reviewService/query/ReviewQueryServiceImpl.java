package umc.spring.service.reviewService.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Page<Review> getMyReview(Long restaurantId, Integer page) {

        Member member = memberRepository.findById(1L).get(); // 나를 1번이라 가정
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> myReviewPage = reviewRepository.findAllByRestaurantAndMember(restaurant, member, PageRequest.of(page, 10));
        return myReviewPage;
    }
}
