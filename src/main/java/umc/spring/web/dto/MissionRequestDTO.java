package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {
        @NotNull
        private Long missionId;

        @NotNull
        private Long memberId;  // 하드코딩 or 요청으로 받을지 결정

        @NotNull
        private Long storeId;

    }
}
