package com.sample.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.demo.model.TennisRacquet;

public interface RacquetRepository extends JpaRepository<TennisRacquet, Long> {

	List<TennisRacquet> findAll(Class<TennisRacquet> class1, String name);

}
