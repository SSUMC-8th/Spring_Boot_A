package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import umc.spring.converter.MemberConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.MemberQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 회원이 작성한 리뷰 목록을 조회합니다. 페이징 포함")
    @ApiResponses({
            @ApiResponse(responseCode = "COMMON200", description = "성공"),
            @ApiResponse(responseCode = "MEMBER4001", description = "존재하지 않는 회원"),
            @ApiResponse(responseCode = "COMMON400", description = "page가 1보다 작음")
    })
    public umc.spring.apiPayload.ApiResponse<MemberResponseDTO.MyReviewPreviewListDTO> getMyReviewList(
            @PathVariable Long memberId,
            @ValidPage @RequestParam Integer page) {

        Page<Review> reviews = memberQueryService.getMyReviews(memberId, page - 1);
        return umc.spring.apiPayload.ApiResponse.onSuccess(MemberConverter.toMyReviewPreviewListDTO(reviews));
    }
}