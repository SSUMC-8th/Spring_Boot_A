package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.exception.NotFoundException;
import umc.spring.domain.Market;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.enums.Progress;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.service.missionService.dto.MissionRequestDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;


@Component
@RequiredArgsConstructor
public class MissionConverter {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final RegionRepository regionRepository;
    private final MarketRepository marketRepository;

    public MemberMission toEntity(MissionRequestDTO.challengeMission dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new NotFoundException("존재하지 않는 회원입니다."));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new NotFoundException("존재하지 않는 미션입니다."));

        Market market = marketRepository.findByName(dto.getMarketName())
                .orElseThrow(()-> new NotFoundException("존재하지 않는 가게입니다."));

        return MemberMission.builder()
                .progress(Progress.IN_PROGRESS)
                .member(member)
                .region(market.getRegion())
                .mission(mission)
                .build();
    }

    public MissionResponseDTO.challengeResponse toDto(MemberMission mission) {
        return MissionResponseDTO.challengeResponse.builder()
                .missionId(mission.getId())
                .marketName(mission.getMission().getMarket().getName())
                .build();
    }
}
