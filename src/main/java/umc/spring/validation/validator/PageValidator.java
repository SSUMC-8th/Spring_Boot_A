package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.validation.annotation.ValidPage;

@Component
public class PageValidator implements ConstraintValidator<ValidPage, Integer> {
    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
//        return page != null && page >= 1;
        if (page == null || page < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("COMMON400")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
