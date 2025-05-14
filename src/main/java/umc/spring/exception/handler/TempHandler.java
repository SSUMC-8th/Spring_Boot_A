package umc.spring.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
