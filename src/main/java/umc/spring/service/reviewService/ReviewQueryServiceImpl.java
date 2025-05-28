package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Review;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.ReviewRepository;


@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MarketRepository marketRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Page<Review> reviewPage = reviewRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));
        return reviewPage;
    }
}
