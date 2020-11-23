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
@Table(name = "horario")
public class Horario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idHorario;
	@Column(name = "dia")
	private String dia;
	@Column(name = "aula")
	private String aula;
	@Column(name = "hora_inicio")
	private String horaInicio;
	@Column(name = "hora_fin")
	private String horaFin;
	
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name = "nasighorario",inverseJoinColumns = @JoinColumn(name = "asignatura_id"), joinColumns = @JoinColumn(name = "horario_id"))
	private List<Asignatura> horario;

	public Integer getIdHorario() {
		return idHorario;
	}



	public List<Asignatura> getHorario() {
		return horario;
	}



	public void setHorario(List<Asignatura> horario) {
		this.horario = horario;
	}



	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	private static final long serialVersionUID = 1L;

}
