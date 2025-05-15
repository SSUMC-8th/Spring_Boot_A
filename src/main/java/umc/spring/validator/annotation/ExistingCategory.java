package umc.spring.validator.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validator.ExistingCategoryValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistingCategoryValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistingCategory {

    String message() default "존재하지 않는 카테고리입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}