package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;

import dal.EmpruntDAO;
import domain.Agent;
import domain.Emprunt;
import domain.Materiel;

public class EmpruntService {

	private static final EmpruntDAO empruntDAO = new EmpruntDAO();

	public void ajouterEmprunt(Agent agent, Materiel materiel) {
		Date dateDuJour = new Date(14, 02, 2019);
		Emprunt emprunt = new Emprunt();
		emprunt.setIdAgent(agent.getId());
		emprunt.setIdMateriel(emprunt.getIdMateriel());
		emprunt.setDateEmprunt(dateDuJour);
		try {
			empruntDAO.create(emprunt);
			System.out.println("Insertion en base d'un nouvel emprunt concernant l'agent numéro : " + agent.getId()
					+ " et le matériel numéro " + materiel.getId());
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'insertion en base  de l'emprunt concernant l'agent numéro "
					+ agent.getId() + " et le matériel numéro " + materiel.getId() + ": " + e);
		}
	}

	public void supprimerEmprunt(Agent agent, Materiel materiel) {
		Emprunt emprunt = new Emprunt();
		emprunt.setIdAgent(agent.getId());
		emprunt.setIdMateriel(materiel.getId());
		try {
			empruntDAO.remove(emprunt);
			System.out.println("Suppression en base de l'emprunt concernant l'agent numéro : " + agent.getId()
			+ " et le matériel numéro " + materiel.getId());
		} catch (SQLException e) {
			System.out.print("Erreur lors de la suppression en base de l'emprunt concernant l'agent numéro : "
					+ agent.getId() + " et le matériel numéro " + materiel.getId() + ": " + e);
		}
	}

	public Date getDateDuJour() {
		Calendar cal = Calendar.getInstance();
		Date date = (Date) cal.getTime();

		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		formatter.format(date);
		return date;
	}
}
