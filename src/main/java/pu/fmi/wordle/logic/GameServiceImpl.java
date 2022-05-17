package pu.fmi.wordle.logic;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pu.fmi.wordle.model.Game;
import pu.fmi.wordle.model.GameRepository;
import pu.fmi.wordle.model.GameStatus;
import pu.fmi.wordle.model.Word;
import pu.fmi.wordle.model.WordRepository;

@Service
@Transactional
public class GameServiceImpl implements GameService {
	@Autowired
	private WordRepository wordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Game createNewGame() {
		Long count = wordRepository.count();
		long index = new Random().nextInt(count.intValue());
		
		Word word = wordRepository.findByOffset(index);
		
		Game game = new Game();
		game.setStatus(GameStatus.IN_PROGRESS);
		game.setTries(0);
		game.setWord(word);
		
		game = gameRepository.save(game);
		
		return game;
	}

	@Override
	public List<Game> listGames() {
		return gameRepository.findAll();
	}
	
	@Override
	public Game getGame(Long id) {
		return gameRepository.findById(id).get();
	

}

	@Override
	public Game makeTry(Long id, String userWord) {
		Game game = gameRepository.findById(id).orElse(null);
		
		if(game == null) {
			throw new IllegalArgumentException("Game not found!");
		}
		
		Word wordCheck = wordRepository.findByValue(userWord);
		
		if(wordCheck == null) {
			throw new IllegalArgumentException("Word not found in dictionary!");
		}
		
		game.setTries(game.getTries() + 1);
		if (userWord.equals(game.getWord().getValue())) {
			game.setStatus(GameStatus.WIN);
		} else if (game.getTries() == 6){
			game.setStatus(GameStatus.LOSS);
		}
		
		//TODO
		return game;
	}
}
