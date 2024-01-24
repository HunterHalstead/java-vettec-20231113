package com.skillstorm.immutables;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is immutable. Once it is created it's state cannot be changed.
 */
public final class RosettaStone {
	
	private final String text;
	
	private final List<Language> languages;
	
	public RosettaStone(String text, List<Language> languages) {
		this.text = text;
		this.languages = copy(languages);
	}

	public String getText() {
		return text;
	}

	public List<Language> getLanguages() {
		return copy(this.languages);
	}
	
	private List<Language> copy(List<Language> lst) {
		List<Language> copy = new ArrayList<>();
		for (Language lang : lst) {
			copy.add(new Language(lang.getName()));
		}
		return copy;
	}
	

}
