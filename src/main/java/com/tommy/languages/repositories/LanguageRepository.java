package com.tommy.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tommy.languages.models.LanguageModel;

public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {
	List<LanguageModel> findAll();
	List<LanguageModel> findById(String search);
	List<LanguageModel> deleteById(String search);
}

