package pu.fmi.wordle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pu.fmi.wordle.model.Word;
import pu.fmi.wordle.model.WordRepository;

@SpringBootTest
class WordleApplicationTests {

	@Autowired
	private WordRepository wordRepository;
	
	@Test
	void createWord() {
		wordRepository.save(new Word("where"));
	}
	
	
	@Test
	void createWords() {
		wordRepository.save(new Word("where"));
		wordRepository.save(new Word("agree"));
		wordRepository.save(new Word("cloud"));
		wordRepository.save(new Word("error"));
		wordRepository.save(new Word("toast"));
		wordRepository.save(new Word("alone"));
		wordRepository.save(new Word("snake"));
	}
	
	@Test
	void findWords() {
		System.out.println(wordRepository.findAll());
	}

}
