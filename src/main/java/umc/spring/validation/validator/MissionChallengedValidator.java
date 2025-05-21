package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.validation.annotation.ChallengedMissions;
import umc.spring.web.dto.MissionDTO.ChallengeRequestDTO;

@Component
public class MissionChallengedValidator
        implements ConstraintValidator<ChallengedMissions, ChallengeRequestDTO> {

    private final MissionChallengeRepository challengeRepo;

    // 생성자 주입
    public MissionChallengedValidator(MissionChallengeRepository challengeRepo) {
        this.challengeRepo = challengeRepo;
    }

    @Override
    public boolean isValid(ChallengeRequestDTO dto, ConstraintValidatorContext ctx) {
        Boolean isNull = (dto.getMemberId() == null || dto.getMissionId() == null);
        Boolean isValid = !challengeRepo
                .existsByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());
        if (!isNull || !isValid) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(ErrorStatus._CONFLICT.toString()).addConstraintViolation();

            return false;
        }
        return true;
    }
}