package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    public static class ReviewAddResultDTO {
        private Long reviewId;
        private LocalDateTime createdAt;
    }
}