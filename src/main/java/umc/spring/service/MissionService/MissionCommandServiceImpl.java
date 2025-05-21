package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handle.TempHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionDTO.ChallengeRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionChallengeRepository challengeRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    /** 1) 미션 새로 도전하기 */
    @Override
    @Transactional
    public void challengeMission(ChallengeRequestDTO request) {
        // Member / Mission 프록시만 가져와서 최소 쿼리
        Member member   = memberRepository.getReferenceById(request.getMemberId());
        Mission mission = missionRepository.getReferenceById(request.getMissionId());

        // 중복 도전 방지
        if (challengeRepository.existsByMemberIdAndMissionId(
                request.getMemberId(), request.getMissionId())) {
            throw new TempHandler(ErrorStatus._CONFLICT);
        }

        // 새로운 도전 기록 생성 (NONE 상태)
        MemberMission entity = MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.NONE)
                .build();

        challengeRepository.save(entity);
    }

    /** 2) 미션 상태를 PROGRESS로 변경하기 */
    @Override
    @Transactional
    public void progressMission(Long memberId, Long missionId) {
        MemberMission mm = challengeRepository
                .findByMemberIdAndMissionId(memberId, missionId)
                .orElseGet(() -> {
                    // 기록이 없으면 새로 만들기 (NONE 상태)
                    Member m   = memberRepository.getReferenceById(memberId);
                    Mission ms = missionRepository.getReferenceById(missionId);
                    return MemberMission.builder()
                            .member(m)
                            .mission(ms)
                            .missionStatus(MissionStatus.NONE)
                            .build();
                });

        // 이미 PROGRESS라면 충돌
        if (mm.getMissionStatus() == MissionStatus.PROGRESS) {
            throw new TempHandler(ErrorStatus._CONFLICT);
        }

        // 상태 변경 후 저장
        mm.setMissionStatus(MissionStatus.PROGRESS);
        challengeRepository.save(mm);
    }
}