package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {

    Page<MemberMission> getOngoingMissions(Long memberId, int page);

    Page<Review> getMyReviews(Long memberId, Integer page);
}
