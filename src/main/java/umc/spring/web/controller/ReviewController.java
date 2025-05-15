package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.marektService.MarketCommandService;
import umc.spring.service.marektService.dto.MarketRequestDTO;
import umc.spring.service.marektService.dto.MarketResponseDTO;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/post")
    public ApiResponse<ReviewResponseDTO.reviewPostResponse> registerMarket(@RequestBody @Valid ReviewRequestDTO.postDTO dto){
        ReviewResponseDTO.reviewPostResponse response = reviewCommandService.postReview(dto);

        return ApiResponse.onSuccess(response);
    }
}
