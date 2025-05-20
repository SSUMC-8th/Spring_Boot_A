package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(
            @PathVariable("storeId") Long storeId,
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request) {

        Review review = reviewCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
