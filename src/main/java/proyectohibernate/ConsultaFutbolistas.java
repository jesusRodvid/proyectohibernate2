package proyectohibernate;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaFutbolistas {
	//static Session sesion = HibernateUtil.getSessionFactory().openSession();
		static SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		static Session sesion = miFactory.openSession();
		static int opcionElegida;

		public static void main(String[] args) {

			String opcionElegidaAux = "";

//			Preguntar opcion
			System.out.println("Escoja una de las siguientes opciones");
			System.out.println("1. Insertar Equipo");
			System.out.println("2. Insertar Equipo con Observación");
			System.out.println("3. Insertar Contrato");
			System.out.println("4. Insertar Liga");
			System.out.println("5. Insertar Futbolista");
			System.out.println("6. Elimina Equipo");
			System.out.println("7. Actualiza Equipo");
			System.out.println("8. Elimina Contrato");
			System.out.println("9. Actualiza Contrato");
			System.out.println("10. Mostrar Equipos");
			System.out.println("11. Mostrar todo");
			Scanner sc = new Scanner(System.in);
			
			opcionElegida= sc.nextInt();
			// Arranca la sesion
			switch (opcionElegida) {
			case 1:
				insertarEquipo();
				break;
			case 2:
				insertarEquipoObservacion();
				break;
			case 3:
				insertarContrato();
				break;
			case 4:
				insertarLiga();
				break;
			case 5:
				insertarFutbolista();
				break;
			case 6:
				eliminaEquipo();
				break;
			case 7:
				actualizaEquipo();
				break;
			case 8:
				eliminaContrato();
				break;
			case 9:
				actualizaContrato();
				break;
			case 10:
				mostrarEquipos();
				break;
			case 11:
				mostrarEquiposContratosFutbolistasLigas();
				break;
			default:
				System.out.println("No has introducido una operación válida");
				break;
			}
		}

		public static void mostrarEquipos() {
			sesion.beginTransaction();
			List<Equipos> eqObs = sesion.createQuery("from equipos, equiposobservaciones").getResultList();
			for (Equipos unEquipo : eqObs)
				System.out.println(unEquipo);
			sesion.close();
		}

		public static void mostrarEquiposContratosFutbolistasLigas() {
			sesion.beginTransaction();
			List<Equipos> eqObs = sesion.createQuery("from equipos, contratos, futbolistas, ligas "
					+ "where equipos.codEquipo=contratos.codEquipo and futbolistas.codDNIoNIE=contratos.codDNIoNIE"
					+ "	and equipos.codLiga=ligas.codLiga").getResultList();
			for (Equipos unEquipo : eqObs)
				System.out.println(unEquipo);
			sesion.close();
		}

		public static void insertarEquipo() {
			sesion.beginTransaction();
			Ligas liga = sesion.get(Ligas.class, "PDN");

			Equipos equipo1 = new Equipos("Tigalate","Tamaraceite",true, liga);

			sesion.save(equipo1);
			sesion.getTransaction().commit();
			sesion.close();

		}

		public static void insertarEquipoObservacion() {
			sesion.beginTransaction();
			Ligas liga = sesion.get(Ligas.class, "PDN");

			Equipos equipo1 = new Equipos("Tigalatebugalooo222", "Tamaraceite",true, liga);

			EquipoObservaciones equiObs = new EquipoObservaciones("Equipazo");

			//equipo1.setEquipoobservaciones(equiObs);
			equiObs.setCodEquipoXXX(equipo1);
			
			sesion.save(equipo1);
			sesion.save(equiObs);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void insertarLiga() {
			sesion.beginTransaction();
			Ligas liga1 = new Ligas("KKK", "Kus Kus Klan");

			sesion.save(liga1);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void insertarContrato() {
			sesion.beginTransaction();

			Futbolistas futbolista = sesion.get(Futbolistas.class, "55555555A");
			Equipos equipo = sesion.get(Equipos.class, 2);
			Contratos contrato = new Contratos(futbolista, equipo, new GregorianCalendar(2014, 7, 1),
					new GregorianCalendar(2019, 6, 30), 30000, 50000);

			sesion.save(contrato);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void insertarFutbolista() {
			sesion.beginTransaction();
			Futbolistas futbolista = new Futbolistas("45634523X", "Pepsiman", "Pepsiland");

			sesion.save(futbolista);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void eliminaEquipo() {
			sesion.beginTransaction();

			Equipos equipo1 = sesion.get(Equipos.class, 1);

			sesion.delete(equipo1);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void actualizaEquipo() {
			sesion.beginTransaction();

			Equipos equipo1 = sesion.get(Equipos.class, 1);
			equipo1.setLocalidad("Chipude");

			// sesion.update(equipo1);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void eliminaContrato() {
			sesion.beginTransaction();

			Contratos contrato = sesion.get(Contratos.class, 3);

			sesion.delete(contrato);
			sesion.getTransaction().commit();
			sesion.close();
		}

		public static void actualizaContrato() {
			sesion.beginTransaction();
			Contratos contrato = sesion.get(Contratos.class, 1);
			contrato.setFechaFin(new GregorianCalendar(2021, 12, 19));

			// sesion.update(contrato);
			sesion.getTransaction().commit();
			sesion.close();
		}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		
//		Session misession=sessionFactory.openSession();
//		
//		try {
//			
//			//comenzar sesion
//			
//			misession.beginTransaction();
//			
//			//consulta
//			
//			List<Futbolistas> losFutbolista= misession.createQuery("from Futbolistas").getResultList();
//			
//			//mostrar futbolistas
//			
//			recorrefutbolistasconsultados(losFutbolista);
//			
//			//mostrar un futbolista en concreto
//			
//			losFutbolista= misession.createQuery("from Futbolistas fb where fb.codDNIoNIE='11111222A'").getResultList();
//			
//			recorrefutbolistasconsultados(losFutbolista);
//			
//			//commit 
//			misession.getTransaction().commit();
//			
//			//cerrar sesion 
//			
//			misession.close();
//
//
//		}finally {
//			
//			sessionFactory.close();
//
//		}
//	}
//
//	private static void recorrefutbolistasconsultados(List<Futbolistas> losFutbolista) {
//		for (Futbolistas unFutbolista:losFutbolista) {
//			
//			System.out.println(unFutbolista);
//		}
//	}

}
