package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation;

import java.util.Date;
import java.util.Random;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation.Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation.IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Implementation.Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Gestionnaire_de_Simulation {
	
	int nbUtilisateur;
	Utilisateur[] tabU;
	int nbNiveau;
	long debutSim;
	Date d;
	
	Ascenseur asc;
	Systeme_de_Controle SdC;
	IHM_Simule IHM;
	
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
			
			tabU[i] = new Utilisateur(i, dep, arr, r.nextInt(1000));
		}
		this.debutSim = System.currentTimeMillis();
		this.d = new Date();
	}
	
	// Classe interne
	private class Utilisateur {
		int id;
		int niveauDepart;
		int niveauArrivee;
		// Temps en millisecondes avant la requ�te de l'utilisateur
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
		// TODO Auto-generated method stub
		
		Gestionnaire_de_Simulation g = new Gestionnaire_de_Simulation(5, 10);
		//g.asc = new Ascenseur();
		//g.IHM = new IHM_Simule();
		g.SdC = new Systeme_de_Controle();
		System.out.println("D�but de la simulation : " + g.d);
		
		// Tant que les requ�tes de tous les utilisateurs n'ont pas �t� trait�es
		while(g.tabU.length > 0) {
			for(int i = 0; i < g.tabU.length; i++) {
				if(g.tabU[i].debutAppel < System.currentTimeMillis() && !g.tabU[i].traitementReq) {
					if(g.tabU[i].Requete() == "Monter") {
						g.SdC.AppelAscenseur(g.tabU[i].niveauDepart, ISysteme_de_Controle.SensAppel.Haut);
					} else {
						g.SdC.AppelAscenseur(g.tabU[i].niveauDepart, ISysteme_de_Controle.SensAppel.Bas);
					}
					
					
					
					System.out.println("L'utilisateur n�"+ i +" a appel� l'ascenseur au niveau " + g.tabU[i].niveauDepart);
					
					
					// On retire l'utilisateur dont la requ�te a �t� trait�
					
					g.tabU[i] = null;
				}
				
				
			}
		}
		
				
		System.out.println("Dur�e de la simulation : " + (System.currentTimeMillis() - g.debutSim) + "ms" );
		System.out.println("Fin de la simulation : " + new Date());
		
	}

}