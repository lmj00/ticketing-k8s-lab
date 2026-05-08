package com.lmj.ticketing.application.concert;

import com.lmj.ticketing.application.concert.dto.ConcertResponse;
import com.lmj.ticketing.infrastructure.persistence.concert.ConcertRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertQueryService {

    private final ConcertRepository concertRepository;

    public List<ConcertResponse> findAll(int page, int size) {
        int pageIndex = Math.max(0, page - 1);
        return concertRepository.findAll(PageRequest.of(pageIndex, size))
                .map(ConcertResponse::from)
                .getContent();
    }
}
