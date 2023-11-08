package ee.mainor.moGame.web;

import ee.mainor.moGame.dto.MoCreateGameRequest;
import ee.mainor.moGame.dto.MoGameResponse;
import ee.mainor.moGame.service.MoGuessingGameService;
import ee.mainor.moGame.repository.MoGuessingGameRepository;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class MoGuessingGameController {

    private final MoGuessingGameService guessingGameService;

    @PostMapping
    public Long createGuessingGame(@RequestBody MoCreateGameRequest gameCreateRequest) {
        return guessingGameService.createGuessingGame(gameCreateRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public MoGameResponse playGame(@PathVariable Long gameId, @PathVariable Integer number) {
        return guessingGameService.playGame(gameId, number);
    }


}