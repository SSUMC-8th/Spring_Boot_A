package umc.spring.service.missionService;

import umc.spring.service.missionService.dto.MissionRequestDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.challengeResponse challengeMission(MissionRequestDTO.challengeMission dto);
}
