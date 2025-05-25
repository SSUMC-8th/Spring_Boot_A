package umc.spring.validator.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validator.MarketExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MarketExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMarket {
    String message() default "가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
