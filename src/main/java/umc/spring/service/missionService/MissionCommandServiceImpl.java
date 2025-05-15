package umc.spring.service.missionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.BadRequestException;
import umc.spring.apiPayload.exception.NotFoundException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.enums.Progress;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.service.missionService.dto.MissionRequestDTO;
import umc.spring.service.missionService.dto.MissionResponseDTO;

import static umc.spring.domain.QMission.mission;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionConverter missionConverter;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MissionResponseDTO.challengeResponse challengeMission(MissionRequestDTO.challengeMission dto) {

        MemberMission mission = missionConverter.toEntity(dto);

        Member member = mission.getMember();
        Mission mmission = mission.getMission();

        // 중복 방지 체크 (이미 도전 중인 경우)
        if (memberMissionRepository.existsByMemberAndMission(member, mmission)) {
            throw new BadRequestException("Mission already exists");
        }


        MemberMission saved = memberMissionRepository.save(mission);

        return missionConverter.toDto(saved);
    }
}
