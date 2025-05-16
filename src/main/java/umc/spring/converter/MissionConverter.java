package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;


import java.time.LocalDateTime;

public class MissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.IN_PROGRESS)
                .build();
    }

    public static MissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .challengedAt(LocalDateTime.now())
                .build();
    }
}