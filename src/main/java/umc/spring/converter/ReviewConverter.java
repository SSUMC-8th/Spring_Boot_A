package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewAddResultDTO toReviewAddResultDTO(Review review){
        return ReviewResponseDTO.ReviewAddResultDTO.builder()
                .reviewId(review.getId())
                .createTime(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewAddDTO request, Store store, Member member){

        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();
    }

}
