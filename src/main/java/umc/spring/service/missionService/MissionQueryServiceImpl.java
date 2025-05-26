package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getMarketMissionList(Long marketId, Integer page) {
        Page<Mission> missionPage = missionRepository.findAllByMarketId(marketId, PageRequest.of(page, 10));
        return missionPage;
    }
}
