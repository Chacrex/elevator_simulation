package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface;

public interface IUtilisateur {
	public void Requete();
	public void Monter();
	public void Descendre();
	public int get_id();
	public int get_debutAppel();
	public int get_niveauDepart();
	public int get_niveauArrivee();
	public boolean get_traitementReq();
	public void TraitementFait();
	
	
}
