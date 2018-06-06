package com.altiuz.ar.monitor.repository;

import com.altiuz.ar.monitor.model.documento;
import com.altiuz.ar.monitor.model.proceso;
import org.springframework.data.jpa.repository.query.Procedure;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface procesoRepository extends JpaRepository<proceso, Long> {
	
	proceso findByIdProceso(String id); 
	
	public List<proceso> findAllByOrderByInicioDesc();
	
	
	@Procedure(name = "countDocByProcess")
	List<Object> countDocByProcess();
	
	@Query(value= "SELECT * FROM altiuzreportsx.proceso where inicio > :fechita" , nativeQuery=true)
	List<proceso> findByhour(@Param("fechita") Timestamp fechita);

	List<proceso> findByIdEstado(int status);
	
	
} 