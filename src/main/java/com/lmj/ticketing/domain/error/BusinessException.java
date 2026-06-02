package com.lmj.ticketing.domain.error;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BookingErrorCode errorCode;
    
    protected BusinessException(BookingErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
