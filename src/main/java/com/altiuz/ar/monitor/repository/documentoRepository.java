package com.altiuz.ar.monitor.repository;

import com.altiuz.ar.monitor.model.documento;
import com.altiuz.ar.monitor.model.proceso;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface documentoRepository extends JpaRepository<documento, Long> {
	
	List<documento> findByProceso(proceso proc); 
	
	public List<proceso> findAllByOrderByFinDesc();

	
	
	
}