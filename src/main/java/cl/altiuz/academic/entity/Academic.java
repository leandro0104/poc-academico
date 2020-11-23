package cl.altiuz.academic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "academico")
public class Academic implements Serializable {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "rut")
	private String rut;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellidos;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "nademiccasig",inverseJoinColumns = @JoinColumn(name = "asignatura_id"), joinColumns = @JoinColumn(name = "academico_id"))
	//@JoinColumn(name = "id")
	private List<Asignatura> asignatura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Asignatura> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	private static final long serialVersionUID = 1L;
}
