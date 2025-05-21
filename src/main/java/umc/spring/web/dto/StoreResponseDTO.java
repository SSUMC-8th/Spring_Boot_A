package umc.spring.web.dto;


import lombok.*;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreAddResultDTO{
        Long storeId;
        LocalDateTime createTime;
    }
}