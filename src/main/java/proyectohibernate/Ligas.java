package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ligas")
public class Ligas {
	@Id
	@Column ( columnDefinition= "char(5)")
	private String 	codLiga; 
	@Column ( columnDefinition= "varchar(50)")
	private String nomLiga;
	
	@OneToMany (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER,mappedBy="ligasobj" )
	//@JoinColumn(name="codEquipo")
	List<Equipos> equipos = new ArrayList<Equipos>();

	public String getCodLiga() {
		return codLiga;
	}

	public void setCodLiga(String codLiga) {
		this.codLiga = codLiga;
	}

	public String getNomLiga() {
		return nomLiga;
	}

	public void setNomLiga(String nomLiga) {
		this.nomLiga = nomLiga;
	}

	public List<Equipos> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}

	public Ligas(String codLiga, String nomLiga) {
		super();
		this.codLiga = codLiga;
		this.nomLiga = nomLiga;
	}

	public Ligas() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
