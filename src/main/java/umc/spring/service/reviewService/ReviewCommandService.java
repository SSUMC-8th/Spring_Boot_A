package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.reviewPostResponse postReview(ReviewRequestDTO.postDTO dto);
}
