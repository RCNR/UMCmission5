package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.command.ReviewCommandService;
import umc.spring.service.reviewService.query.ReviewQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.reviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "review 관련 API")
@RequestMapping("/reviews")
public class ReviewController {


    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResponseDTO> createReview(
            @Valid @RequestBody ReviewRequestDTO.CreateReviewDTO dto) {

        Review review = reviewCommandService.createReview(dto);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResponseDTO(review));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 API", description = "내가 작성한 리뷰 목록을 보는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getMyReviewList(
            @PathVariable Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Review> myReviewList = reviewQueryService.getMyReview(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDTO(myReviewList));
    }

}
