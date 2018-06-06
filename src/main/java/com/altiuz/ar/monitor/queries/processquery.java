package com.altiuz.ar.monitor.queries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.altiuz.ar.monitor.model.proceso;

public class processquery {
	public proceso getprocessbyid(EntityManager em, String id) {
	    TypedQuery<proceso> query = em.createQuery(
	        "SELECT c FROM Country c WHERE c.name = :name"
	      + "SELECT * FROM altiuzreportsx.proceso  where id_proceso=:id", proceso.class);
	    
	    
	    proceso proc = new proceso();
	    proc.setIdProceso("sdasbuibaskasjbak");
	    proc.setIdEstado(1);
	    
	    
	    
	    
	    return query.setParameter("id", id).getSingleResult();
	  } 
	
}
