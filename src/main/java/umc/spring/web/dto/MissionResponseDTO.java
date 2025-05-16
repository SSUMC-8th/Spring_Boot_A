package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    public static class ChallengeResultDTO {
        private Long memberMissionId;
        private LocalDateTime challengedAt;
    }
}