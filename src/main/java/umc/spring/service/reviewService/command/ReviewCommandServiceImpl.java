package umc.spring.service.reviewService.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.exception.handler.MemberHandler;
import umc.spring.apiPayload.code.exception.handler.RegionHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review createReview(ReviewRequestDTO.CreateReviewDTO dto) {

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(
                () -> new RegionHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(
                () -> new MemberHandler((ErrorStatus.MEMBER_NOT_FOUND)));

        return reviewRepository.save(ReviewConverter.toReview(dto, restaurant, member));
    }
}
