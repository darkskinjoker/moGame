package ee.mainor.moGame.service;

import ee.mainor.moGame.dto.MoCreateGameRequest;
import ee.mainor.moGame.dto.MoGameResponse;
import ee.mainor.moGame.model.MoGuessingGame;
import ee.mainor.moGame.repository.MoGuessingGameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MoGuessingGameService {
    private final MoGuessingGameRepository moguessingGameRepository;

    public Long createGuessingGame(MoCreateGameRequest gameCreationRequest) {
        MoGuessingGame guessingGame = new MoGuessingGame();
        guessingGame.setCorrectNumber(gameCreationRequest.getCorrectAnswer());
        return moguessingGameRepository.save(guessingGame).getId();
    }

    public MoGameResponse playGame(Long gameId, Integer number) {
        MoGuessingGame guessingGame = moguessingGameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("Game with given UUID does not eist"));


        MoGameResponse gameResponse = new MoGameResponse();

        if (guessingGame.getCorrectNumber() > number) {
            gameResponse.setTextResponse("Nr smaller");
        } else if (guessingGame.getCorrectNumber() < number) {
            gameResponse.setTextResponse("Nr bigger than correct correct number");
        }
        else gameResponse.setTextResponse("Congrats");
        return gameResponse;
    }

}