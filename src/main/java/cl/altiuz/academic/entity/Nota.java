package cl.altiuz.academic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "nota")
public class Nota implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "unidad")
	private String unidad;
	@Column(name = "evaluacion")
	private String evaluacion;
	@Column(name = "fecha_evaluacion")
	private String fechaEvaluacion;
	
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "nasignota", inverseJoinColumns = @JoinColumn(name = "asign_id"), joinColumns = @JoinColumn(name = "nota_id"))
	private List<Asignatura>nota;

	public Integer getId() {
		return id;
	}

	public List<Asignatura> getNota() {
		return nota;
	}

	public void setNota(List<Asignatura> nota) {
		this.nota = nota;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(String fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	private static final long serialVersionUID = 1L;

}
