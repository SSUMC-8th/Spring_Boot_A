package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewAddDTO {
        @NotNull
        private Long storeId;

        @NotBlank
        private String content;

        @NotNull
        private Integer score;
    }
}