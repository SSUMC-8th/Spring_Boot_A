package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Component
@RequiredArgsConstructor
public class ChallengedMissionValidaotor implements ConstraintValidator<umc.spring.validation.annotation.ChallengedMission, MissionRequestDTO.ChallengeMissionDTO> {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(MissionRequestDTO.ChallengeMissionDTO dto, ConstraintValidatorContext context) {
        if (dto == null) return true;

        // DB에서 엔티티 조회
        Member member = memberRepository.findById(dto.getMemberId()).orElse(null);
        Mission mission = missionRepository.findById(dto.getMissionId()).orElse(null);

        if (member == null || mission == null) return true;

        boolean exists = memberMissionRepository.existsByMemberAndMission(member, mission);

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}