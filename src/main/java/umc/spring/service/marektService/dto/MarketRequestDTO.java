package umc.spring.service.marektService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class MarketRequestDTO {

    @Getter
    public static class registerDTO{

        @NotBlank(message="이름은 필수입니다.")
        String name;

        @NotBlank(message="시 단위로 적어주세요 / 필수 값입니다.")
        String address;// 얘는 그냥 서울특별시 동작구, 경기도 시흥시 정도...?


        String detailAddress; // 얘는 그냥 세부주소이고

        @NotBlank(message = "정수로 입력해주세요 / 필수 값입니다.")
        Long category_id; // 어차피 카테고리 몇개 안되니까 프론트에서 처리해준다고 가정
    }
}
