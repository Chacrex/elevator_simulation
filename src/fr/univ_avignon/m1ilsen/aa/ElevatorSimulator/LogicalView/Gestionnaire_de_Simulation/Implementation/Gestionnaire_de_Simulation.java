package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation;


import java.util.Date;
import java.util.Random;

public class Gestionnaire_de_Simulation {
	
	int nbUtilisateur;
	Utilisateur[] tabU;
	int nbNiveau;
	long debutSim;
	Date d;
	
	// Constructeur Gestionnaire_de_Simulation
	public Gestionnaire_de_Simulation(int nbUtilisateur, int nbNiveau) {
		Random r = new Random();
		
		this.nbUtilisateur = nbUtilisateur;
		// Test nbNiveau valide (nbNiveau > 2)
		if(nbNiveau < 2) {
			System.out.println("nbNiveau invalide : " + nbNiveau + " (nb sup�rieur � 2 requis)\n Initialisation de nbNiveau � 2");
			nbNiveau = 2;
		}
		
		tabU = new Utilisateur[nbUtilisateur];
		for(int i = 0; i < nbUtilisateur; i ++) {
			// G�n�rer al�atoirement les niveaux d�part et arriv�e de l'utilisateur
			int dep = r.nextInt(nbNiveau);
			int arr;
			// On s'assure que le niveau de d�part est diff�rent de celui d'arriv�e
			do {
				arr = r.nextInt(nbNiveau);
			} while (arr != dep);
			
			tabU[i] = new Utilisateur(i, dep, arr);
		}
		this.debutSim = System.currentTimeMillis();
		this.d = new Date();
	}
	
	// Classe interne
	private class Utilisateur {
		int id;
		int niveauDepart;
		int niveauArrivee;
		
		float tempsAttente;
		
		// Constructeur Utilisateur
		public Utilisateur(int id, int niveauDepart, int niveauArrivee) {
			this.id = id;
			this.niveauDepart = niveauDepart;
			this.niveauArrivee = niveauArrivee;
			this.tempsAttente = 0;
		}
	}

	/*
	 * Faire les tests du DUMMY SYSTEM ici
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gestionnaire_de_Simulation g = new Gestionnaire_de_Simulation(5, 10);
		System.out.println("D�but de la simulation : " + g.d);
				
		System.out.println("Dur�e de la simulation : " + (System.currentTimeMillis() - g.debutSim) + "ms" );
		System.out.println("Fin de la simulation : " + new Date());
		
	}

}