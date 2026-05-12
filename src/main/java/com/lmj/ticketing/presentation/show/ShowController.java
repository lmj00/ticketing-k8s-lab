package com.lmj.ticketing.presentation.show;

import com.lmj.ticketing.application.show.ShowQueryService;
import com.lmj.ticketing.application.show.dto.ShowResponse;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts/{concertId}/shows")
public class ShowController {

    private final ShowQueryService showQueryService;

    @GetMapping
    public List<ShowResponse> getShowsByConcert(@PathVariable Long concertId) {
        return showQueryService.findAllByConcertId(concertId);
    }
}
