package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.reviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {


    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResponseDTO> createReview(@Valid @RequestBody ReviewRequestDTO.CreateReviewDTO dto) {

        Review review = reviewCommandService.createReview(dto);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResponseDTO(review));
    }
}
