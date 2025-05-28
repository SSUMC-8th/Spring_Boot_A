package umc.spring.service.missionService.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistMarket;

public class MissionRequestDTO {

    @Getter
    public static class challengeMission{
        private Long memberId;

        @ExistMarket
        private String marketName;

        private Long missionId;
    }
}
