package pu.fmi.wordle.logic;

import java.util.List;

import pu.fmi.wordle.model.Game;

public interface GameService {
	Game createNewGame();

	List<Game> listGames();
	
	public Game getGame(Long id);

	Game makeTry(Long id, String userWord);
}
