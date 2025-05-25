package umc.spring.service.missionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface MissionQueryService {
    Page<Mission> getMarketMissionList(Long marketId, Integer page);
}
