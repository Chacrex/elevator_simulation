package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface;

public interface ISysteme_de_Controle {
	int AffichagePosition();
	void AppelAscenseur(int niveauAppel);
	void ChoixNiveau(int niveau);
}
