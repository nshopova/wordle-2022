package pu.fmi.wordle.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pu.fmi.wordle.logic.GameService;
import pu.fmi.wordle.model.Game;

@RestController
@RequestMapping("/api")
public class GameApi {
	
	@Autowired
	private GameService gameService;

	@PostMapping("/games")
	public Game createNewGame() {
		return gameService.createNewGame();
	}
	
	@GetMapping("/games")
	public List<Game> listGames() {
		return gameService.listGames();
	}
	
	@GetMapping("/games/{id}")
	public Game getGame(@PathVariable Long id) {
		return gameService.getGame(id);
	}
	
	@PutMapping("/games/{id}")
	public ResponseEntity<?> makeTry(@PathVariable Long id, @RequestParam String userWord) {
		Game game;
		try {
			game = gameService.makeTry(id, userWord);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(game);
	}
}
