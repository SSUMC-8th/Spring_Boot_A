package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class createMissionDTO {

        @NotBlank
        private String missionCondition;

        @NotNull
        @Min(1)
        private Integer point;

        @NotNull
        @Future
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime dueDate;
    }

}
