package com.altiuz.ar.monitor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import com.altiuz.ar.monitor.model.proceso;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="documento")
@NamedQuery(name="documento.findAll", query="SELECT d FROM documento d")
public class documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DOCUMENTO")
	private int idDocumento;
	
	@Lob
	@Column(name="CRITERIOBUSQUEDA")
	private String criteriobusqueda;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="FIN")
	private Timestamp fin;
	
	

	@Column(name="id_estado")
	private int idEstado;

	@Column(name="id_formato")
	private int idFormato;

	@Column(name="id_tipo")
	private int idTipo;

	@Column(name="INICIO")
	private Timestamp inicio;

	@Column(name="LINK")
	private String link;

	@Lob
	private String log;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="ID_PROCESO")
	@JsonBackReference
	private proceso proceso;

	public documento() {
	}

	public String getCriteriobusqueda() {
		return this.criteriobusqueda;
	}

	public void setCriteriobusqueda(String criteriobusqueda) {
		this.criteriobusqueda = criteriobusqueda;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFin() {
		return this.fin;
	}

	public void setFin(Timestamp fin) {
		this.fin = fin;
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdFormato() {
		return this.idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Timestamp getInicio() {
		return this.inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(proceso proceso) {
		this.proceso = proceso;
	}

	
    
	}
	
	
	

