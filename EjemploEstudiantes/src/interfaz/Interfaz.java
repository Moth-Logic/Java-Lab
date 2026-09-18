package interfaz;

import logica.Estudiante;
import logica.Grupo;

public class Interfaz {
	
	public static void main(String[] args) {
		try {
			Estudiante e1 = new Estudiante("2026086615", "Jose Julian Solorzano", "j.solorzano.2@estudiantec.cr", "87465660");
			Estudiante e2 = new Estudiante("2026112233", "Armando Paredes", "sin.camisa@estudiantec.cr", "88881111");
			Estudiante e3 = new Estudiante("2026445566", "Aquiles Baeza", "el.fastidioso@estudiantec.cr", "87654321");
			Estudiante e4 = new Estudiante("2026778899", "Elba Lazo", "aprietame.fuerte@estudiantec.cr", "83332211");
			Estudiante e5 = new Estudiante("2026123456", "Inés Tornillo", "se.me.va.la.tuerca@estudiantec.cr", "85554433");
			Estudiante e6 = new Estudiante("2026654321", "Esteban Dido", "profe.deme.puntos@estudiantec.cr", "89990000");
			Estudiante e7 = new Estudiante("2026987654", "Miren Amurrio", "estudiando.en.el.bano@estudiantec.cr", "84447777");
			Estudiante e8 = new Estudiante("2026334455", "Helen Cha", "la.culpa.es.del.grupo@estudiantec.cr", "82221144");
			Estudiante e9 = new Estudiante("2026228844", "Alan Brito Delgado", "no.entiendo.poo@estudiantec.cr", "86669911");
			Estudiante e10 = new Estudiante("2026551199", "Susana Oria", "solo.vengo.por.el.cafe@estudiantec.cr", "81110022");

			Grupo g1 = new Grupo(40, "SJ", "L-V 7:30-9:20", "Introducción al Llantito en el Baño");
			Grupo g2 = new Grupo(1, "CARTAGO", "K-J 13:00-14:50", "Técnicas Aceptables para Vender Órganos");
			Grupo g3 = new Grupo(2, "ALAJUELA", "M 18:00-21:30", "Cómo Sobrevivir con Maruchan y Ansiedad");
			Grupo g4 = new Grupo(3, "LIMON", "L-V 06:00-07:50", "Llenado Avanzado de Solicitudes en McDonald's");
			Grupo g5 = new Grupo(4, "SAN CARLOS", "S 08:00-12:00", "Simulación de Exorcismo a Servidores en Producción");
			Grupo g6 = new Grupo(5, "SJ", "K-J 09:30-11:20", "Introducción a la Calvicie Prematura por Estrés");
			Grupo g7 = new Grupo(6, "CARTAGO", "V 15:00-17:50", "Aceptación del Abandono Familiar y Afectivo");
			Grupo g8 = new Grupo(7, "ALAJUELA", "L-M 10:00-11:50", "Cómo Ocultar la Depresión Detrás de Memes");
			Grupo g9 = new Grupo(8, "SAN CARLOS", "J 14:00-17:00", "Lógica de Algoritmos para Romper Matrimonios");
			Grupo g10 = new Grupo(9, "LIMON", "W 19:00-22:00", "Estrategias de Escape de Detención Fiscal");

			g1.agregarEstudiante(e1);
			g1.agregarEstudiante(e2);
			g1.agregarEstudiante(e3);

			g2.agregarEstudiante(e4);
			g2.agregarEstudiante(e5);
			g2.agregarEstudiante(e6);

			g3.agregarEstudiante(e7);
			g3.agregarEstudiante(e8);
			g3.agregarEstudiante(e9);

			g4.agregarEstudiante(e10);
			g4.agregarEstudiante(e1);
			g4.agregarEstudiante(e2);

			g5.agregarEstudiante(e3);
			g5.agregarEstudiante(e4);
			g5.agregarEstudiante(e5);

			g6.agregarEstudiante(e6);
			g6.agregarEstudiante(e7);
			g6.agregarEstudiante(e8);

			g7.agregarEstudiante(e9);
			g7.agregarEstudiante(e10);
			g7.agregarEstudiante(e1);

			g8.agregarEstudiante(e2);
			g8.agregarEstudiante(e3);
			g8.agregarEstudiante(e4);

			g9.agregarEstudiante(e5);
			g9.agregarEstudiante(e6);
			g9.agregarEstudiante(e7);

			g10.agregarEstudiante(e8);
			g10.agregarEstudiante(e9);
			g10.agregarEstudiante(e10);

			
			Grupo[] todosLosGrupos = {g1, g2, g3, g4, g5, g6, g7, g8, g9, g10};
			
			for (Grupo grupo : todosLosGrupos) {
				System.out.println("\nGrupo " + grupo.getNumero() + " - " + grupo.getNombreMateria() + " (" + grupo.getSede() + "):");
				for (Estudiante est : grupo.getEstudiantes()) {
					System.out.println("  - " + est.getNombre() + " | Correo: " + est.getEmail());
				}
			}

		} catch (Exception e) {
			System.out.println("Error en la ejecución: " + e.getMessage());
		}
	}
}