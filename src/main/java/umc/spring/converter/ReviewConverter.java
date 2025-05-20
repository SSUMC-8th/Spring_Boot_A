package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request, Member member, Store store) {
        return Review.builder()
                .rate(request.getRate())
                .content(request.getContent())
                .member(member)
                .store(store)
                .build();
    }
}
