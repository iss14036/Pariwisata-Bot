package com.Pariwisata.models.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer>{
	
	Event findByEventDescriptionContaining(String eventDescription);
	
}
