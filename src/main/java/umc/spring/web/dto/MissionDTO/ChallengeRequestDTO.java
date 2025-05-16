package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ChallengedMissions;

@Getter
@NoArgsConstructor
@ChallengedMissions
public class ChallengeRequestDTO {

    @NotNull(message = "memberId는 필수입니다.")
    private Long memberId;

    @NotNull(message = "missionId는 필수입니다.")
    private Long missionId;

}