package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    public static class ChallengeMissionResultDTO {
        private Long memberMissionId;
        private String status;
    }
}
