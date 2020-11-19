package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="futbolistas")
public class Futbolistas {


	@Id
	@Column(columnDefinition= "char(9)")
	private String codDNIoNIE;
	
	@Column(columnDefinition= "varchar (50)")
	private String nombre;

	@Column(columnDefinition= "varchar (40)")
	private String nacionalidad;
	
	@OneToMany (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER,mappedBy="futbolistaobj" )
	//@JoinColumn(name="codDNIoNIE")
	List<Contratos> contratos = new ArrayList<Contratos>();

	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String toString() {
		return "Futbolistas [codDNIoNIE=" + codDNIoNIE + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", contratos=" + contratos + "]";
	}

	public Futbolistas(String codDNIoNIE, String nombre, String nacionalidad) {
		super();
		this.codDNIoNIE = codDNIoNIE;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;	}

	public Futbolistas() {
		super();
		// TODO Auto-generated constructor stub
	} 

	
}
