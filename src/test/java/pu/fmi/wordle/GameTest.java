package pu.fmi.wordle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pu.fmi.wordle.model.Game;
import pu.fmi.wordle.model.GameRepository;
import pu.fmi.wordle.model.GameStatus;
import pu.fmi.wordle.model.Word;
import pu.fmi.wordle.model.WordRepository;

@SpringBootTest
public class GameTest {
	@Autowired
	WordRepository wordRepository;
	
	@Autowired 
	GameRepository gameRepository;

	@Test
	void createNewGame() {
		Word word = wordRepository.findById(1L).orElse(null);
		
		Game game = new Game();
		game.setStatus(GameStatus.IN_PROGRESS);
		game.setTries(0);
		game.setWord(word);
		
		gameRepository.save(game);
	}
}
