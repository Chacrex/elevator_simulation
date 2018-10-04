package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface;

public interface ISysteme_de_Controle {
	public enum SensAppel {
		Haut, Bas
	}
	
	int AffichagePosition();
	void AppelAscenseur(int niveauAppel, SensAppel sens);
	void ChoixNiveau(int niveau);
	void Set_OuverturePorte(boolean ouverturePorte);
}
