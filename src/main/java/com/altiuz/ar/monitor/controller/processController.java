package com.altiuz.ar.monitor.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 

import com.altiuz.ar.monitor.model.documento;
import com.altiuz.ar.monitor.model.proceso;
import com.altiuz.ar.monitor.queries.processquery;
import com.altiuz.ar.monitor.repository.documentoRepository;
import com.altiuz.ar.monitor.repository.procesoRepository;;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8001"}, maxAge = 6000)
@RequestMapping("/api-monitor-ar")
public class processController {

	@Autowired
	procesoRepository PROCRepo;
	@Autowired
	documentoRepository DOCRepo;

	processquery query; 
	// Get All process
	@GetMapping("/process")
	public List<proceso> getAllProcess() {
		return PROCRepo.findAllByOrderByInicioDesc();
	}


	@PostMapping("/process")
	public proceso createNote(@Valid @RequestBody proceso process) {
		return PROCRepo.save(process);
	}

	@RequestMapping(value = "/process/{id}", method = RequestMethod.GET)
	public proceso getProcessbyID_PROCESO(@PathVariable String id) {	
		return PROCRepo.findByIdProceso(id); 
	}

	@PutMapping("/process/{id}")
	public proceso updateNote(@PathVariable(value = "id") String processId, @Valid @RequestBody proceso procesoDetails) {
		proceso proc = PROCRepo.findByIdProceso(processId);
		proc.setFin(procesoDetails.getFin());
		proc.setIdEstado(procesoDetails.getIdEstado());
		proceso updatedProcess = PROCRepo.save(proc);
		return updatedProcess;
	}
	@RequestMapping(value = "/process/last/{hour}", method = RequestMethod.GET)
	public List<proceso> getProcessbyHour(@PathVariable long hour) {	
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR,  (int) ((hour) * -1));
		Date dateBeforeXDays = cal.getTime();
		String fechaFormato =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateBeforeXDays);
		System.out.println(fechaFormato);
		Timestamp timed = new Timestamp(cal.getTimeInMillis());
		return PROCRepo.findByhour(timed);  
	}

	@GetMapping("/document") 
	public List<documento> getAllDoc() {
		return DOCRepo.findAll();
	}
	

	@PostMapping("/document/{process}") 
	public documento createDocument(@PathVariable (value = "process") String process, @Valid @RequestBody documento doc) {
		proceso idproceso = new proceso();
		idproceso.setIdProceso(process);
		doc.setProceso(idproceso);
		return DOCRepo.save(doc);
	}

	@RequestMapping(value = "/document/{proc}", method = RequestMethod.GET)
	public List<documento> getDocumentbyProceso(@PathVariable String proc) {	
		proceso idproceso = new proceso();
		idproceso.setIdProceso(proc);
		return DOCRepo.findByProceso(idproceso);  
	}
	@RequestMapping(value = "/process/status/{status}", method = RequestMethod.GET)
	public List<proceso> getProcessbyStatus(@PathVariable int status) {	
		
		return PROCRepo.findByIdEstado(status);  
	}

}
