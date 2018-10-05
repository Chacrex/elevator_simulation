package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface;

public interface IGestionnaire_de_Simulation {
	public void LancerSimulation();
	public void AjouterUtilisateur(int id, int niveauDepart, int niveauArrivee, int debutAppel);
}
