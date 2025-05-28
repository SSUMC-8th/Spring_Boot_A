package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.exception.NotFoundException;
import umc.spring.domain.Market;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ReviewConverter {


    private final MemberRepository memberRepository;
    private final MarketRepository marketRepository;

    public Review convertToEntity(ReviewRequestDTO.postDTO dto) {
        Member member = memberRepository.findById(1L) // 하드 코딩
                .orElseThrow(() -> new NotFoundException("Member not found"));

        Market market = marketRepository.findByName(dto.getMarketName())
                .orElseThrow(() -> new NotFoundException("Market not found"));

        return Review.builder()
                .content(dto.getContent())
                .member(member)
                .market(market)
                .evalutaion(dto.getEvaluation())
                .build();
    }

    public ReviewResponseDTO.reviewPostResponse convertToDTO(Review review) {
        return ReviewResponseDTO.reviewPostResponse.builder()
                .marketName(review.getMarket().getName())
                .evaluation(review.getEvalutaion())
                .build();
    }


    public static ReviewResponseDTO.myReviewDTO toMyReview(Review review){
        return ReviewResponseDTO.myReviewDTO.builder()
                .content(review.getContent())
                .rate(review.getEvalutaion())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.myReviewListDTO toMyReviewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.myReviewDTO> myReviewDTOList = reviewList.stream()
                .map(ReviewConverter::toMyReview).collect(Collectors.toList());

        return ReviewResponseDTO.myReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(myReviewDTOList.size())
                .reviewList(myReviewDTOList)
                .build();
    }

}
