package umc.spring.apiPayload.code.status;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500","서버 에러, 관리자에게 문의하세요."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEMBER4001","사용자를 찾을 수 없습니다"),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002","닉네임이 존재하지 않습니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001", "이것은 테스트"),
    FOODCATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST,"CATEGORY4001", "카테고리가 존재하지 않습니다."),
    MARKET_NOT_FOUND(HttpStatus.BAD_REQUEST, "MARKET4001","해당 가게가 존재하지 않습니다."),

    PAGE_MISSING(HttpStatus.BAD_REQUEST, "REVIEW4001", "요청 페이지를 입력해주세요."),
    INVALID_PAGE_RANGE(HttpStatus.BAD_REQUEST, "REVIEW4001", "1이상의 정수를 입력해주세요");



    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    public static ErrorStatus fromCode(String code) {
        for (ErrorStatus status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return _BAD_REQUEST; // 못 찾았을 때 기본값
    }
}
