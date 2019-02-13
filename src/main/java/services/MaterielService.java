package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.MaterielDAO;
import domain.Materiel;

public final class MaterielService {

	private static final MaterielDAO materielDao = new MaterielDAO();

	public Materiel recupererMaterielEnBdd(int idAgent) {
		try {
			Materiel materiel = materielDao.findById(idAgent);
			return materiel;
		} catch (SQLException e) {
			System.out.println("Erreur lors de la r�cup�ration du mat�riel de l'agent " + idAgent + " : " + e);
		}
		return null;
	}

	public List<Materiel> recupererToutLeMaterielEnBDD(int idAgent) {
		List<Materiel> liste = new ArrayList<Materiel>();
		try {
			liste = materielDao.findAll();
		} catch (SQLException e) {
			System.out.println(
					"Erreur lors de la r�cup�ration de l'ensemble du mat�riel de l 'agent  " + idAgent + " : " + e);
		}
		return liste;
	}

	public void decrementerMateriel(Materiel materiel) {
		if (materiel.getQuantite() > 0) {
			materiel.setQuantite(materiel.getQuantite() - 1);
			try {
				materielDao.update(materiel);
				System.out.println("Le nombre de " + materiel.getLibelle() + " a �t� d�cr�ment� de 1");
			} catch (SQLException e) {
				System.out.println("Erreur lors de la d�cr�mentation du nombre de " + materiel.getLibelle());
			}
		}

	}

	public void incrementerMateriel(Materiel materiel) {
		materiel.setQuantite(materiel.getQuantite() + 1);
		try {
			materielDao.update(materiel);
			System.out.println("Le nombre de " + materiel.getLibelle() + " a �t� incr�ment� de 1");
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'incr�mentation du nombre de " + materiel.getLibelle());
		}
	}

}
