package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreAddResultDTO {
        private Long storeId;
        private LocalDateTime createdAt;
    }


    //특정가게의 미션목록 조회
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDTO {
        private Long missionId;
        private String missionDetail;
        private LocalDate deadline;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDTO {
        private List<MissionPreviewDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }


}
