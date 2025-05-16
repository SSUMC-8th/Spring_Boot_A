package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.ReviewAddDTO request, Store store, Member member) {
        return Review.builder()
                .content(request.getContent())
                .rate(Float.valueOf(request.getScore()))
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.ReviewAddResultDTO toReviewAddResultDTO(Review review) {
        return ReviewResponseDTO.ReviewAddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
