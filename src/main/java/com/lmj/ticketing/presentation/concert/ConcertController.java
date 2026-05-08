package com.lmj.ticketing.presentation.concert;

import com.lmj.ticketing.application.concert.ConcertQueryService;
import com.lmj.ticketing.application.concert.dto.ConcertResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts")
public class ConcertController {

    private final ConcertQueryService concertQueryService;

    @GetMapping
    public List<ConcertResponse> getConcerts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return concertQueryService.findAll(page, size);
    }
}
