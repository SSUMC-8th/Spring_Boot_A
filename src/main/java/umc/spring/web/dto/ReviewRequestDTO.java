package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "5.0", inclusive = true)
        private Float rate;

        @NotBlank
        @Size(max = 256)
        private String content;
    }
}
