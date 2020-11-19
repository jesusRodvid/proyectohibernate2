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
	String 	codLiga; 
	@Column ( columnDefinition= "varchar(50)")
	String nomLiga;
	
	@OneToMany (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER,mappedBy="ligasobj" )
	//@JoinColumn(name="codEquipo")
	List<Equipos> residencia = new ArrayList<Equipos>();

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

	public List<Equipos> getResidencia() {
		return residencia;
	}

	public void setResidencia(List<Equipos> residencia) {
		this.residencia = residencia;
	}
	
}
