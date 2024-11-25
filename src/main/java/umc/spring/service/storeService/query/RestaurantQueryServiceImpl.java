package umc.spring.service.storeService.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findRestaurantByNameAndScore(String name, Float score) {

        List<Restaurant> filteredRestaurants = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredRestaurants.forEach(restaurant -> System.out.println("Restaurant: " + restaurant));

        return filteredRestaurants;
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> RestaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));

        return RestaurantPage;
    }
}
