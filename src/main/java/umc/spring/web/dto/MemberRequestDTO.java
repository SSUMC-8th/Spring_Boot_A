package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.enums.FoodKind;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.SocialType;
import umc.spring.validation.annotation.ExistFoodKinds;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        SocialType socialType;
        @NotNull
        String email;
        @NotBlank
        String name;
        @NotBlank
        String nickname;
        @NotNull
        Gender gender;
        @NotNull
        LocalDate birthDate;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String detailAddress;
        @Min(0)
        Integer point;
//        @Schema(hidden = true) // Swagger에서 제외
        @ExistFoodKinds
        List<FoodKind> favoredFoodsList;
    }
}
