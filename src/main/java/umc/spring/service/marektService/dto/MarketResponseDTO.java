package umc.spring.service.marektService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.service.reviewService.dto.ReviewResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class MarketResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterMarketResponse{
        private Long id ;
        private String name ;
        private String code;
    }

}
