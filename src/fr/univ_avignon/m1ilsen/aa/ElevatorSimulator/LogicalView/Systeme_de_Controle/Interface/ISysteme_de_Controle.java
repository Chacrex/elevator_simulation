package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;

public interface ISysteme_de_Controle {
	public enum SensAppel {
		Haut, Bas
	}
	
	int AffichagePosition();
	void AppelAscenseur(int niveauAppel, SensAppel sens);
	void ChoixNiveau(int niveau);
	void Set_OuverturePorte();
	public void AssignerAscenseur(IAscenseur ascenseurAssigner);
}
