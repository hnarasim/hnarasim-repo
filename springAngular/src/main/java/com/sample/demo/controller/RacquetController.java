package com.sample.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.exception.SearchNotfoundException;
import com.sample.demo.model.TennisRacquet;
import com.sample.demo.repo.RacquetRepository;
import com.sample.demo.utils.Constants;

@RestController
@RequestMapping("/api")
public class RacquetController {

	private static final String SEARCH_NOT_FOUND = "Service Issue, Did not get any response. Problem with the Search!!";
	private static final String INVALID_NAME = "Service Issue, Racquet cannot be Blank!!";

	@Autowired
	private RacquetRepository racquetRepository;

	@GetMapping(Constants.GET_ALL_RACQUETS)
	public List<TennisRacquet> allRackets() {
		return racquetRepository.findAll();
	}

	@GetMapping(Constants.GET_RACQUET_BY_ID)
	public TennisRacquet getRacket(@PathVariable Long id) {
		return racquetRepository.findById(id).orElse(null);
	}

	@GetMapping(Constants.GET_RACQUETS_BY_NAME)
	public List<TennisRacquet> getRacketsbyName(@PathVariable String name) {
		return racquetRepository.findAll(TennisRacquet.class, name);

	}

	@DeleteMapping(Constants.DELETE_RACQUET_BY_ID)
	public boolean deleteRacket(@PathVariable Long id) {
		racquetRepository.deleteById(id);
		return true;
	}

	@PutMapping(Constants.UPDATE_RACQUET)
	public TennisRacquet updateRacket(TennisRacquet tennisRacquet) {
		if (tennisRacquet.getName() == null) {
			throw new SearchNotfoundException(INVALID_NAME);
		}
		return racquetRepository.save(tennisRacquet);
	}

	@PostMapping(Constants.NEW_RACQUET)
	public TennisRacquet createRacket(TennisRacquet tennisRacquet) {
		if (tennisRacquet.getName() == null) {
			throw new SearchNotfoundException(INVALID_NAME);
		}
		return racquetRepository.save(tennisRacquet);
	}

}
