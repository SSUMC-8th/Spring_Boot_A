package umc.spring.validator;

import jakarta.validation.ConstraintValidator;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MarketRepository;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.validator.annotation.ExistMarket;


@Component
@RequiredArgsConstructor
public class MarketExistValidator implements ConstraintValidator<ExistMarket, String> {
    private final MarketRepository marketRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return false;

        boolean exists = marketRepository.existsByName(value);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("존재하지 않는 마켓입니다.")
                    .addConstraintViolation();
        }

        return exists;
    }
}
