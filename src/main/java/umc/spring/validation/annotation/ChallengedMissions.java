package umc.spring.validation.annotation;

import jakarta.validation.Payload;

public @interface ChallengedMissions {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
