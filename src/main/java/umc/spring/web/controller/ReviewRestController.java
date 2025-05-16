package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/add")
    public ApiResponse<ReviewResponseDTO.ReviewAddResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.ReviewAddDTO request) {

        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(
                ReviewResponseDTO.ReviewAddResultDTO.builder()
                        .reviewId(review.getId())
                        .createdAt(review.getCreatedAt())
                        .build()
        );
    }
}