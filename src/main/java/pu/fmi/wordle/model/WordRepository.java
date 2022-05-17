package pu.fmi.wordle.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long>{
	Word findByValue(String value); 
	
	@Query (
			value = "select * from word limit 1 offset :offset",
			nativeQuery = true
	)
	Word findByOffset(Long offset);
}
