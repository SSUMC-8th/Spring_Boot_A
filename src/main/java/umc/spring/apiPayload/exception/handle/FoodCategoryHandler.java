package umc.spring.apiPayload.exception.handle;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}