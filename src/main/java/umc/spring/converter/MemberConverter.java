package umc.spring.converter;

//내가 작성한 리뷰 목록 조회

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.List;

public class MemberConverter {

    public static MemberResponseDTO.MyReviewPreviewDTO toMyReviewPreviewDTO(Review review) {
        return MemberResponseDTO.MyReviewPreviewDTO.builder()
                .score(review.getRate())
                .body(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MyReviewPreviewListDTO toMyReviewPreviewListDTO(Page<Review> reviewPage) {
        List<MemberResponseDTO.MyReviewPreviewDTO> dtoList = reviewPage.stream()
                .map(MemberConverter::toMyReviewPreviewDTO)
                .toList();

        return MemberResponseDTO.MyReviewPreviewListDTO.builder()
                .reviewList(dtoList)
                .listSize(dtoList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}