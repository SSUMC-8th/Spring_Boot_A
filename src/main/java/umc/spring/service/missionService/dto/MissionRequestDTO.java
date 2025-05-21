package umc.spring.service.missionService.dto;

import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class challengeMission{
        private Long memberId;
        private String marketName;
        private Long missionId;
    }
}
