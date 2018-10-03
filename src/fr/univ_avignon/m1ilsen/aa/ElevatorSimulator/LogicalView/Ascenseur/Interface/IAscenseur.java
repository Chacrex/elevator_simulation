package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface;


public interface IAscenseur {
	public enum Sens {
		Montee, Descente
	}
	
	public enum Etat_Ascenseur{
		Repos, Deplacement, Transitoire
	}
	
	void Marche(Sens sens);
	void Arret_Niveau();
	Etat_Ascenseur get_etat();
	int get_position();
	Sens get_sens();
}