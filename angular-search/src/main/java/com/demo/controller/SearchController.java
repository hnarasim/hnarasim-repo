package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.SearchNotfoundException;
import com.demo.model.TennisRacquet;
import com.demo.service.SearchService;
import com.demo.utils.Constants;

@RestController
public class SearchController {
	
	private static final String SEARCH_NOT_FOUND = "Service Issue, Did not get any response. Problem with the Search!!";
	
	@Autowired
	private SearchService searchSrv;
	
	@RequestMapping("/test")
    public String testSpring() { 
		return "Spring Working"; 
	}
	
	@GetMapping(Constants.GET_ALL_RACQUETS)
    public List<TennisRacquet> allRackets() {
		return searchSrv.getAllRackets(); 
	}
	
	@GetMapping(Constants.GET_RACQUETS_BY_NAME)
	public List<TennisRacquet> getRacketsbyName(@PathVariable String name) {
		
		List<TennisRacquet> filteredList =  searchSrv.getmatchRackets(name);
		if (filteredList.isEmpty() ) {
			throw new SearchNotfoundException(SEARCH_NOT_FOUND);
		}
						
		return searchSrv.getmatchRackets(name);
		
	}
}
