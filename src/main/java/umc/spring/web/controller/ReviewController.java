package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.restaurantDTO.RestaurantResponseDTO;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.reviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewController {


    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResponseDTO> createReview(
            @Valid @RequestBody ReviewRequestDTO.CreateReviewDTO dto) {

        Review review = reviewCommandService.createReview(dto);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResponseDTO(review));
    }
}
