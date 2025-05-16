
package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository; // 수정된 부분

    @Override
    @Transactional
    public MemberMission createChallenge(MissionRequestDTO.ChallengeMissionDTO request){

        // 임시: 첫 번째 사용자 사용
        Member member = memberRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 이미 도전한 미션인지 검사
        if (memberMissionRepository.existsByMemberAndMission(member, mission)) {
            throw new MissionHandler(ErrorStatus.ALREADY_CHALLENGED_MISSION);  // 반드시 정의 필요
        }

        // MemberMission 생성
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.IN_PROGRESS)  // 이 부분이 핵심!
                .authNumber("1234")  // 임시 값
                .build();

        return memberMissionRepository.save(memberMission);
    }
}



//package umc.spring.service.MissionService;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import umc.spring.apiPayload.code.status.ErrorStatus;
//import umc.spring.apiPayload.exception.handler.MemberHandler;
//import umc.spring.apiPayload.exception.handler.MissionHandler;
//import umc.spring.apiPayload.exception.handler.StoreHandler;
//import umc.spring.converter.MissionConverter;
//import umc.spring.domain.Member;
//import umc.spring.domain.Store;
//import umc.spring.domain.mapping.MemberMission;
//import umc.spring.domain.Mission;
//import umc.spring.repository.MemberMissionRepository;
//import umc.spring.repository.MemberRepository;
//import umc.spring.repository.MissionRepository;
//import umc.spring.web.dto.MissionRequestDTO;
//
//@Service
//@RequiredArgsConstructor
//public class MissionCommandServiceImpl implements MissionCommandService {
//
//    private final MemberRepository memberRepository;
//    private final MissionRepository missionRepository;
//    private final MemberMissionRepository memberMissionRepository;
//    private final MemberRepository storeRepository;
//
//    @Override
//    @Transactional
//    public MemberMission createChallenge(MissionRequestDTO.ChallengeMissionDTO request) {
//
//        // 하드코딩된 유저 (첫 번째 사용자)
//        Member member = memberRepository.findAll().stream().findFirst()
//                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
//
//        Mission mission = missionRepository.findById(request.getMissionId())
//                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
//
//        // Store 조회
//        Member store = storeRepository.findById(request.getStoreId())
//                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
//
//        // 도전 중인지 검증은 커스텀 어노테이션으로 선처리?
//
//        MemberMission memberMission = MissionConverter.toMemberMission(member, mission);
//
//        return memberMissionRepository.save(memberMission);
//    }
//}