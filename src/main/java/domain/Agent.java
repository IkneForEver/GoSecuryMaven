package domain;

import java.sql.Date;

public class Agent{
	
	/*
	 * identifiant unique de l'agent
	 */
	private int id;
	
	/*
	 * nom de l'agent
	 */
	private String nom;
	
	/*
	 * prenom de l'agent
	 */
	private String prenom;
	
	/*
	 * date de naissance de l'agent
	 */
	private Date dateNaissance;
	
	/*
	 * Constructeur vide
	 */
	public Agent() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}	
}