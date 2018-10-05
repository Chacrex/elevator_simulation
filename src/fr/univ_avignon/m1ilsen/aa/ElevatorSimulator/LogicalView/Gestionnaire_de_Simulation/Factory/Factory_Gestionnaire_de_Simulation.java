package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Factory;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation.Gestionnaire_de_Simulation;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation.Utilisateur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface.IGestionnaire_de_Simulation;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface.IUtilisateur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;

public class Factory_Gestionnaire_de_Simulation {
	public static IGestionnaire_de_Simulation CreeGestionnaire_de_Simulation(int nombreNiveau, IIHM_Simule ihm)
	{
		return new Gestionnaire_de_Simulation(nombreNiveau, ihm);
	}
	
	public static IUtilisateur CreeUtilisateur(int id, int niveauDepart, int niveauArrivee, int debutAppel,  IIHM_Simule ihm)
	{
		return new Utilisateur(id, niveauDepart, niveauArrivee, debutAppel, ihm);
	}
}
