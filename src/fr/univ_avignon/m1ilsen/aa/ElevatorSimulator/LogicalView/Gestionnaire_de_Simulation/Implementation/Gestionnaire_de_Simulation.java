package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Factory.Factory_IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Factory.Factory_Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Gestionnaire_de_Simulation {
	
	int nbUtilisateur;
	List<Utilisateur> listeUtil;
	int nbNiveau;
	long debutSim;
	Date d;
	
	// Constructeur Gestionnaire_de_Simulation
	public Gestionnaire_de_Simulation(int nbUtilisateur, int nbNiveau) {
		Random r = new Random();
		
		this.nbUtilisateur = nbUtilisateur;
		// Test nbNiveau valide (nbNiveau > 2)
		if(nbNiveau < 2) {
			System.out.println("nbNiveau invalide : " + nbNiveau + " (nb supérieur à 2 requis)\n Initialisation de nbNiveau à 2");
			nbNiveau = 2;
		}
		
		listeUtil = new ArrayList<Utilisateur>();
		for(int i = 0; i < nbUtilisateur; i ++) {
			// Générer aléatoirement les niveaux départ et arrivée de l'utilisateur
			int dep = r.nextInt(nbNiveau);
			int arr;
			// On s'assure que le niveau de départ est différent de celui d'arrivée
			do {
				arr = r.nextInt(nbNiveau);
			} while (arr != dep);
			
			listeUtil.add(new Utilisateur(i, dep, arr, r.nextInt(1000)));
		}
		this.debutSim = System.currentTimeMillis();
		this.d = new Date();
	}
	
	// Classe interne
	private class Utilisateur {
		int id;
		int niveauDepart;
		int niveauArrivee;
		// Temps en millisecondes avant la requête de l'utilisateur
		int debutAppel;
		boolean traitementReq = false;
		
		// Constructeur Utilisateur
		public Utilisateur(int id, int niveauDepart, int niveauArrivee, int debutAppel) {
			this.id = id;
			this.niveauDepart = niveauDepart;
			this.niveauArrivee = niveauArrivee;
			this.debutAppel = debutAppel;
		}
		
		private String Requete() {
			if(niveauDepart < niveauArrivee) {
				return "Monter";
			} else {
				return "Descendre";
			}
		}
	}

	/*
	 * Faire les tests du DUMMY SYSTEM ici
	 */
	public static void main(String[] args) {
		
		// Paramètres de la simulation
		final int nbNiv = 5;
		final int vitMoteur = 10;
		
		Gestionnaire_de_Simulation g = new Gestionnaire_de_Simulation(10, nbNiv);
		
		ISysteme_de_Controle SdC = Factory_Systeme_de_Controle.CreerSysteme_de_Controle();
		IAscenseur Asc = Factory_Ascenseur.CreerAscenseur(5, vitMoteur, SdC);
		IIHM_Simule Ihm = Factory_IHM_Simule.CreerIhm_Simule(nbNiv, SdC);
		
		System.out.println("Début de la simulation : " + g.d);
		
		// Tant que les requêtes de tous les utilisateurs n'ont pas été traitées
		while(!g.listeUtil.isEmpty()) {
			for(int i = 0; i < g.listeUtil.size(); i++) {
				if(g.listeUtil.get(i).debutAppel < System.currentTimeMillis() && !g.listeUtil.get(i).traitementReq) {
					if(g.listeUtil.get(i).Requete() == "Monter") {
						SdC.AppelAscenseur(g.listeUtil.get(i).niveauDepart, ISysteme_de_Controle.SensAppel.Haut);
					} else {
						SdC.AppelAscenseur(g.listeUtil.get(i).niveauDepart, ISysteme_de_Controle.SensAppel.Bas);
					}
					
					
					
					System.out.println("L'utilisateur n°"+ i +" a appelé l'ascenseur au niveau " + g.listeUtil.get(i).niveauDepart);
					
					
					// On retire l'utilisateur dont la requête a été traité
					
					g.listeUtil.remove(i);
				}
				
				
			}
		}
		
				
		System.out.println("Durée de la simulation : " + (System.currentTimeMillis() - g.debutSim) + "ms" );
		System.out.println("Fin de la simulation : " + new Date());
		
	}

}