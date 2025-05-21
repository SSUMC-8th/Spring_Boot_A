package umc.spring.service.MissionService;

import umc.spring.domain.Review;
import umc.spring.web.dto.MissionDTO.ChallengeRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface MissionCommandService {
        /** 미션 도전(새로 기록 생성) */
        void challengeMission(ChallengeRequestDTO request);

        /** 도전 기록이 없으면 생성하고, 상태를 PROGRESS로 변경 */
        void progressMission(Long memberId, Long missionId);
    }