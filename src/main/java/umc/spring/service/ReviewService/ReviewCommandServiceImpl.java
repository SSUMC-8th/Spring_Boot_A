package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handle.TempHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRespository.StoreRepository;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.ReviewAddDTO request) {

        // 1. store 조회
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new TempHandler(ErrorStatus._BAD_REQUEST));

        // 2) member_id=2 로 DB에서 가져오기
        Member member = memberRepository.findById(2L).orElseThrow(() ->
                new TempHandler(ErrorStatus._BAD_REQUEST));

        Review newReview = ReviewConverter.toReview(request, store, member);

        return reviewRepository.save(newReview);
    }
}
