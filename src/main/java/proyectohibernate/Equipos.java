package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipos {
	
	@Id
	@Column(columnDefinition= "int(11)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEquipo;
	
	@Column(columnDefinition="varchar(40")
	private String nomEquipo;
	
	/*@Column(columnDefinition="char(5)")
	private String codLiga;*/

	@Column(columnDefinition="varchar(60)")
	private String localidad;
	
	@Column(columnDefinition="bit")
	private boolean internacional;

	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@PrimaryKeyJoinColumn (name="codEquipo")
	private EquipoObservaciones equipoobservaciones;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="equiposobj" )
	//@JoinColumn(name="codResidencia")
	List<Contratos> contratos = new ArrayList<Contratos>(); 
	
	@ManyToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER )
	@JoinColumn(name="codLiga")
	private Ligas ligasobj;
	
	
	public Equipos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	/*public String getCodLiga() {
		return codLiga;
	}

	public void setCodLiga(String codLiga) {
		this.codLiga = codLiga;
	}*/

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}


	public EquipoObservaciones getEquipoobservaciones() {
		return equipoobservaciones;
	}


	public void setEquipoobservaciones(EquipoObservaciones equipoobservaciones) {
		this.equipoobservaciones = equipoobservaciones;
	}


	public List<Contratos> getContratos() {
		return contratos;
	}


	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}


	public Ligas getLigasobj() {
		return ligasobj;
	}


	public void setLigasobj(Ligas ligasobj) {
		this.ligasobj = ligasobj;
	}


	@Override
	public String toString() {
		return "Equipos [codEquipo=" + codEquipo + ", nomEquipo=" + nomEquipo + ", localidad=" + localidad
				+ ", internacional=" + internacional + ", equipoobservaciones=" + equipoobservaciones + ", contratos="
				+ contratos + ", ligasobj=" + ligasobj + "]";
	}


	public Equipos( String nomEquipo, String localidad, boolean internacional, Ligas ligasobj) {
		super();
		this.nomEquipo = nomEquipo;
		this.localidad = localidad;
		this.internacional = internacional;
		this.ligasobj = ligasobj;
	}
	
}
