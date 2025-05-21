package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.domain.enums.FoodKind;
import umc.spring.validation.annotation.ExistFoodKinds;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class FoodKindExistValidator implements ConstraintValidator<ExistFoodKinds, List<FoodKind>> {

    private final Set<FoodKind> validFoodKinds = Set.of(FoodKind.values());

    @Override
    public boolean isValid(List<FoodKind> foodKindList, ConstraintValidatorContext context) {
        if (foodKindList == null) return true; // @NotNull은 따로 처리

        for (FoodKind foodKind : foodKindList) {
            if (!validFoodKinds.contains(foodKind)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()
                ).addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}
