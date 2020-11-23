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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "docente")
	private String docente;
	@Column(name = "asistencia")
	private String asistencia;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "nademiccasig", inverseJoinColumns = @JoinColumn(name = "academico_id"), joinColumns = @JoinColumn(name = "asignatura_id"))
	private List<Academic> asignatura;

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "nasighorario", inverseJoinColumns = @JoinColumn(name = "horario_id"), joinColumns = @JoinColumn(name = "asignatura_id"))
	private List<Horario> horario;
	
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "nasignota", inverseJoinColumns = @JoinColumn(name = "nota_id"), joinColumns = @JoinColumn(name = "asign_id"))
	private List<Nota>nota;

	public Integer getId() {
		return id;
	}

	public List<Nota> getNota() {
		return nota;
	}

	public void setNota(List<Nota> nota) {
		this.nota = nota;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	public List<Academic> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<Academic> asignatura) {
		this.asignatura = asignatura;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	private static final long serialVersionUID = 1L;

}
