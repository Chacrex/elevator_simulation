package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Factory.Factory_Gestionnaire_de_Simulation;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface.IGestionnaire_de_Simulation;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface.IUtilisateur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Factory.Factory_IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Factory.Factory_Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Gestionnaire_de_Simulation implements IGestionnaire_de_Simulation {
	
	List<IUtilisateur> listeUtil;
	int nbNiveau;
	long debutSim;
	Date d;
	IIHM_Simule ihm;
	
	// Constructeur Gestionnaire_de_Simulation
	public Gestionnaire_de_Simulation(int nbNiveau, IIHM_Simule uneihm) {
		ihm = uneihm;
		// Test nbNiveau valide (nbNiveau > 2)
		if(nbNiveau < 2) {
			System.out.println("nbNiveau invalide : " + nbNiveau + " (nb supérieur à 2 requis)\n Initialisation de nbNiveau à 2");
			nbNiveau = 2;
		}
		
		listeUtil = new ArrayList<IUtilisateur>();
		this.debutSim = System.currentTimeMillis();
		this.d = new Date();
		
	}
	
	public void LancerSimulation()
	{
		System.out.println("Début de la simulation : " + d);

		// Tant que les requêtes de tous les utilisateurs n'ont pas été traitées
		
		while(!listeUtil.isEmpty()) {
			for(int i = 0; i < listeUtil.size(); i++) {
				if(listeUtil.get(i).get_debutAppel() < System.currentTimeMillis() && !listeUtil.get(i).get_traitementReq()) {
					listeUtil.get(i).Requete();
					
					
					
					System.out.println("L'utilisateur n°"+ i +" a appelé l'ascenseur au niveau " + listeUtil.get(i).get_niveauDepart());
					
					
					// On retire l'utilisateur dont la requête a été traité
					
					listeUtil.remove(i);
				}
				
				
			}
		}

		System.out.println("Durée de la simulation : " + (System.currentTimeMillis() - debutSim) + "ms" );
		System.out.println("Fin de la simulation : " + new Date());
	}
	
	public void AjouterUtilisateur(int id, int niveauDepart, int niveauArrivee, int debutAppel)
	{
		listeUtil.add(Factory_Gestionnaire_de_Simulation.CreeUtilisateur( id, niveauDepart, niveauArrivee, debutAppel, ihm));
	}

	/*
	 * Faire les tests du DUMMY SYSTEM ici
	 */
	public static void main(String[] args) {
		
		// Paramètres de la simulation
		final int nbNiv = 5;
		final int vitMoteur = 10;
		int nbUtilisateur = 10;
		
		// Creation de l'environnement de la simulation entiére
		



		ISysteme_de_Controle SdC = Factory_Systeme_de_Controle.CreerSysteme_de_Controle();
		IAscenseur Asc = Factory_Ascenseur.CreerAscenseur(5, nbUtilisateur, SdC);
		IIHM_Simule Ihm = Factory_IHM_Simule.CreerIhm_Simule(nbNiv, SdC);
		IGestionnaire_de_Simulation g = Factory_Gestionnaire_de_Simulation.CreeGestionnaire_de_Simulation(nbNiv, Ihm);
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! J'ai rajouter les deux lignes du dessous car elles sont importantes pour éviter les bugs !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		SdC.AssignerAscenseur(Asc);
		SdC.AssignerIHM(Ihm);
		
		
		Random r = new Random();

		for(int i = 0; i < nbUtilisateur; i ++) {
			// Générer aléatoirement les niveaux départ et arrivée de l'utilisateur
			int dep = r.nextInt(nbNiv);
			int arr;
			// On s'assure que le niveau de départ est différent de celui d'arrivée
			do {
				arr = r.nextInt(nbNiv);
			} while (arr != dep);
			
			g.AjouterUtilisateur(i, dep, arr, r.nextInt(1000));
		}
		
		
		
		g.LancerSimulation();
		
		
	}

}