package com.Pariwisata.models.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StateRepository extends CrudRepository<State, Integer> {
	
	@Query("SELECT t FROM t_state t where t.id_user = :id") 
	State findStateByIdUser(@Param("id") String id);
	
	State findByPlatformContaining(String platform);
}
