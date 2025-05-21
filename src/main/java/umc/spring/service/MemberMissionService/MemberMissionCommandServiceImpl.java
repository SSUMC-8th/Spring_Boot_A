package umc.spring.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.exception.GeneralException;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MemberMissionResponseDTO.ChallengeMissionResultDTO challengeMission(Long storeId, Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        if (!mission.getStore().getId().equals(storeId)) {
            throw new GeneralException(ErrorStatus.MISSION_STORE_MISMATCH);
        }

        boolean alreadyChallenging = memberMissionRepository
                .findByMemberIdAndMissionIdAndMissionStatus(memberId, missionId, MissionStatus.IN_PROGRESS)
                .isPresent();

        if (alreadyChallenging) {
            throw new GeneralException(ErrorStatus.ALREADY_CHALLENGING_MISSION);
        }

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toChallengeMissionResultDTO(memberMission);
    }
}
