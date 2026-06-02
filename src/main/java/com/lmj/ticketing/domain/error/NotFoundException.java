package com.lmj.ticketing.domain.error;

public class NotFoundException extends BusinessException {

    public NotFoundException(BookingErrorCode errorCode) {
        super(errorCode);
    }
}
