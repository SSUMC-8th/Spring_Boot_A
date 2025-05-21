package umc.spring.service.reviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.reviewService.dto.ReviewRequestDTO;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewConverter reviewConverter;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResponseDTO.reviewPostResponse postReview(ReviewRequestDTO.postDTO dto){

        Review review = reviewConverter.convertToEntity(dto);
        Review saved = reviewRepository.save(review);

        return reviewConverter.convertToDTO(saved);
    }

}
