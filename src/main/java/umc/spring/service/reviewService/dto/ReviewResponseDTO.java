package umc.spring.service.reviewService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO
{
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reviewPostResponse{
        String marketName;
        int evaluation;
    }
}
