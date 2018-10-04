package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;

public interface ISysteme_de_Controle {
	public enum SensAppel {
		Haut, Bas
	}
	
	public int AffichagePosition();
	public void AppelAscenseur(int niveauAppel, SensAppel sens);
	public void ChoixNiveau(int niveau);
	public void Set_OuverturePorte();
	public void AssignerAscenseur(IAscenseur ascenseurAssigner);
	public void AssignerIHM(IIHM_Simule ascenseurIHM);

}
