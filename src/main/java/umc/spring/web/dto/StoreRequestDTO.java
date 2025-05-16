package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class StoreAddDTO {

        //지역 내에 가게 추가시 가게의 이름과 주소, 가게의 id가 포함되어야하므로 (3가지에 대해 json으로 받고 dto로 매핑 맞나?)

        @NotBlank
        private String name;

        @NotBlank
        private String address;

        @NotNull
        private Long regionId;


        private String detailAddress;  // 그냥 추가적인거? (일단 추가)

        private Float rate;            // 그냥 추가적인거?

    }
}
