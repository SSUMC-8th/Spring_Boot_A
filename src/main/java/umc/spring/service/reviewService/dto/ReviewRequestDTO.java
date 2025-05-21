package umc.spring.service.reviewService.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class postDTO{

        @NotBlank(message="255자 이하 작성요망 / 필수 값입니다.")
        String content;

        @NotNull
        @Max(value = 5)
        @Min(value = 0)
        int evaluation;

        @NotBlank(message = "필수 값입니다.")
        String marketName;
    }
}
