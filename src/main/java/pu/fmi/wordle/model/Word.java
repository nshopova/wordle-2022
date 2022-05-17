package pu.fmi.wordle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table()
public class Word {

	@Id
	@GeneratedValue
	private Long id;
	
	private String value;
	
	public Word() {
		super();
	}
	public Word(String value) {
		super();
		this.value = value;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", value=" + value + "]";
	}
}
