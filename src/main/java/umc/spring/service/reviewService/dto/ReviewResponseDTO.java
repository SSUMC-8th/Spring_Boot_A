package umc.spring.service.reviewService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myReviewListDTO{
        List<myReviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myReviewDTO{
        String content;
        int rate;
        LocalDate createdAt;
    }

}
