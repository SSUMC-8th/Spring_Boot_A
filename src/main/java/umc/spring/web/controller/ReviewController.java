package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.service.reviewService.ReviewQueryService;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;
import umc.spring.validation.annotation.ValidPage;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/post")
    public ApiResponse<ReviewResponseDTO.reviewPostResponse> registerReview(@RequestBody @Valid ReviewRequestDTO.postDTO dto){

        ReviewResponseDTO.reviewPostResponse response = reviewCommandService.postReview(dto);

        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{memberId}")
    @Operation(summary = "나의 리뷰 조회하기 API",
            description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저 아이디를 넘겨주세요(아마 로그인 완료된 토큰으로 바뀔 것")
    })
    public ApiResponse<ReviewResponseDTO.myReviewListDTO>
    getReviewList(@PathVariable(name = "memberId") Long memberId,
                  @ValidPage Integer page){
        Page<Review> reviewList = reviewQueryService.getReviewList(memberId,page);
        return ApiResponse.onSuccess(ReviewConverter.toMyReviewListDTO(reviewList));
    }

}
