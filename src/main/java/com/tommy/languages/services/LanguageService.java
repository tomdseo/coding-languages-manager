package com.tommy.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tommy.languages.repositories.LanguageRepository;

import com.tommy.languages.models.LanguageModel;

@Service
public class LanguageService {
	//adding the language repository as a dependency
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// returns all the languages
    public List<LanguageModel> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public LanguageModel createLanguage(LanguageModel b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public LanguageModel findLanguage(Long id) {
        Optional<LanguageModel> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    // deletes a book
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    // updates a book
    public LanguageModel updateLanguage(LanguageModel b) {
    	return languageRepository.save(b);
    }
	
}
