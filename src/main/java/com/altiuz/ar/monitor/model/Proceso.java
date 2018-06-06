package com.altiuz.ar.monitor.model;

import com.altiuz.ar.monitor.model.documento;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="proceso")
@NamedQuery(name="proceso.findAll", query="SELECT p FROM proceso p")
public class proceso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proceso")
	private String idProceso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fin; 

	@Column(name="id_estado")
	private int idEstado;

	@Column(name="id_formato")
	private int idFormato;

	@Column(name="id_tipo")
	private int idTipo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Column(name="total_documentos")
	private int totalDocumentos;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="proceso")
	@JsonManagedReference
	private List<documento> documentos;

	public proceso() {
	}

	public String getIdProceso() {
		return this.idProceso;
	}

	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
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

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public int getTotalDocumentos() {
		return this.totalDocumentos;
	}

	public void setTotalDocumentos(int totalDocumentos) {
		this.totalDocumentos = totalDocumentos;
	}

	public List<documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<documento> documentos) {
		this.documentos = documentos;
	}

	public documento addDocumento(documento documento) {
		getDocumentos().add(documento);
		documento.setProceso(this);

		return documento;
	}

	public documento removeDocumento(documento documento) {
		getDocumentos().remove(documento);
		documento.setProceso(null);

		return documento;
	}

	
	}
	
	
	

