package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class StoreAddDTO{
        @NotBlank
        private String name;
        @Size(min = 5, max = 15)
        private String address;
        @NotNull
        private Long regionId;
    }
}
