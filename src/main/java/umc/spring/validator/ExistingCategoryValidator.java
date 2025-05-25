package umc.spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validator.annotation.ExistingCategory;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExistingCategoryValidator implements ConstraintValidator<ExistingCategory, Long> {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistingCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return false; // or true depending on null policy

        boolean exists = foodCategoryRepository.existsById(value);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOODCATEGORY_NOT_FOUND.getCode())
                    .addConstraintViolation();
        }
        return exists;

    }
}