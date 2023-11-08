package ee.mainor.moGame.repository;
import ee.mainor.moGame.model.MoGuessingGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MoGuessingGameRepository extends JpaRepository<MoGuessingGame, Long> {
    List<MoGuessingGame> findAllByCorrectNumber(Integer correctNumber);

}