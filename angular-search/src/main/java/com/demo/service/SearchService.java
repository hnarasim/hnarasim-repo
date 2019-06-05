package com.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.TennisRacquet;

@Service
public class SearchService {
	
	private List<TennisRacquet> rackets = Arrays.asList(
	new TennisRacquet("Wilson Pro Staff 97L"),
	new TennisRacquet("Wilson Roger Federer 23"),
	new TennisRacquet("Wilson Federer Control 103"),
	new TennisRacquet("Wilson Pro Staff 26"),
	new TennisRacquet("Wilson Ultra 25 Junior Team"),
	new TennisRacquet("Babolat Pure Strike 16×19"),
	new TennisRacquet("Babolat Pure Aero"),
	new TennisRacquet("Wilson Pro Staff RF97 Autograph"),
	new TennisRacquet("Yonex EZONE DR 98 Blue"),
	new TennisRacquet("Babolat Pure Drive"),
	new TennisRacquet("Head Graphene 360 Speed Pro"),
	new TennisRacquet("Yonex VCORE Pro 97 310"),
	new TennisRacquet("Wilson Blade 98 Countervail 18×20"),
	new TennisRacquet("Volkl V-Feel 8 300g"),
	new TennisRacquet("Prince Phantom Pro 100"),
	new TennisRacquet("Wilson Ultra Tour"),
	new TennisRacquet("Prince Textreme Tour 95"),
	new TennisRacquet("Wilson Burn 100 Countervail"),
	new TennisRacquet("Yonex VCORE 98 305"),
	new TennisRacquet("Prince Warrior Textreme 100"),
	new TennisRacquet("Tecnifibre T-Flash 300 Dynacore"),
	new TennisRacquet("HEAD Graphene 360 Extreme Pro"),
	new TennisRacquet("Tecnifibre TFight 300 XTC"),
	new TennisRacquet("HEAD Graphene 360 Instinct MP"),
	new TennisRacquet("Prince Textreme Beast 100"),
	new TennisRacquet("Wilson Ultra 100 Countervail")
	);
	
	public List<TennisRacquet> getAllRackets(){
		return rackets;
	}
	
	public List<TennisRacquet> getmatchRackets(String name){
		
		List<TennisRacquet> filteredList = new ArrayList<>();
        for (TennisRacquet line : rackets) {
            if (line.getName().toLowerCase().contains(name.toLowerCase())) { 
            	filteredList.add(line);
            }
        }
        return filteredList;
	}
	
}
