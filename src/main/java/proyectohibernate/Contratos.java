package proyectohibernate;

import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="contratos")
public class Contratos {
	

	@Id
	@Column ( columnDefinition= "int(11)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codContrato;
	
	/*@Column(columnDefinition= "char(9)")
	private String codDNIoNIE;*/
	
	/*@Column(columnDefinition= "int(11)")
	private int codEquipo;*/
	
	
	@Column ( columnDefinition= "date")
	private GregorianCalendar fechaInicio ;
	
	@Column ( columnDefinition= "date")
	private GregorianCalendar fechaFin ; 
			
	@Column ( columnDefinition= "int(11)")
	private int precioAnual ; 
	
	@Column ( columnDefinition= "int(11)")
	private int precioRecision ;
	
	@ManyToOne (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER )
	@JoinColumn(name="codDNIoNIE")
	private Futbolistas futbolistaobj;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codEquipo")
	private Equipos equiposobj; 

	public Contratos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	/*public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}*/

	/*public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}*/

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecioAnual() {
		return precioAnual;
	}

	public void setPrecioAnual(int precioAnual) {
		this.precioAnual = precioAnual;
	}

	public int getPrecioRecision() {
		return precioRecision;
	}

	public void setPrecioRecision(int precioRecision) {
		this.precioRecision = precioRecision;
	}

	public Futbolistas getFutbolistaobj() {
		return futbolistaobj;
	}

	public void setFutbolistaobj(Futbolistas futbolistaobj) {
		this.futbolistaobj = futbolistaobj;
	}

	public Equipos getEquiposobj() {
		return equiposobj;
	}

	public void setEquiposobj(Equipos equiposobj) {
		this.equiposobj = equiposobj;
	}

	

	
}
