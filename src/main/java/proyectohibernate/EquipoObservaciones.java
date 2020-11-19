package proyectohibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="equiposobservaciones")
public class EquipoObservaciones {
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "codEquipoXXX")})
	Integer codEquipo ;
	
	@Column ( columnDefinition= "varchar(200)")
	String 	observaciones ; 
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	/*cascade={CascadeType.PERSIST,CascadeType.REMOVE}*/
	@PrimaryKeyJoinColumn
	private Equipos codEquipoXXX;

	public EquipoObservaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(Integer codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Equipos getCodEquipoXXX() {
		return codEquipoXXX;
	}

	public void setCodEquipoXXX(Equipos codEquipoXXX) {
		this.codEquipoXXX = codEquipoXXX;
	}
	
	
}
