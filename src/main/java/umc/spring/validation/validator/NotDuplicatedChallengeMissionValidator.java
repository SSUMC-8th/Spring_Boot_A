package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotDuplicatedChallengeMission;

@Component
@RequiredArgsConstructor
public class NotDuplicatedChallengeMissionValidator implements ConstraintValidator<NotDuplicatedChallengeMission, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 예: 현재 로그인된 사용자 ID (실제 구현에서는 SecurityContext 등 사용)

        if (!memberMissionRepository.findByMemberIdAndMissionIdAndMissionStatus( memberId, missionId, MissionStatus.IN_PROGRESS).isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.ALREADY_CHALLENGING_MISSION.toString()
            ).addConstraintViolation();
            return false;
        }
        return true;
    }
}