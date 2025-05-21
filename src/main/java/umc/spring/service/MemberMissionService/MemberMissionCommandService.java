package umc.spring.service.MemberMissionService;

import umc.spring.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    public MemberMissionResponseDTO.ChallengeMissionResultDTO challengeMission(Long storeId, Long missionId, Long memberId);
}
