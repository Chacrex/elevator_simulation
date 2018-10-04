package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Factory.Factory_IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIndoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Factory.Factory_Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

import java.util.List;

public class IHM_Simule implements IIHM_Simule {
	
	private IIndoor ihmIndoor;
	private IOutdoor[] ihmOutdoor;
	private ISysteme_de_Controle SdC;
	
	public IHM_Simule(int nbNiveau, ISysteme_de_Controle sdcontrole) {
		this.ihmIndoor = Factory_IHM_Simule.CreerIndoor();
		this.SdC = sdcontrole;
		this.ihmOutdoor = new Outdoor[nbNiveau];
		for(int i = 0; i < nbNiveau; i++) {
			Factory_IHM_Simule.CreerOutdoor(i);
		}
		this.SdC = Factory_Systeme_de_Controle.CreerSysteme_de_Controle();
	}
	
	public void GererPortes(int niveau, boolean b) {
		ihmOutdoor[niveau].SetEtatPortes(b);
	}
	
	public int AffichageEtage() {
		return SdC.AffichagePosition();
	}
	
	public static void main(String[] args) {
		/*
		 * Scénario : 
		 * - L'utilisateur démarre du niveau 0
		 * - L'utilisateur souhaite voir la position de l'ascenseur
		 * - L'utilisateur souhaite monter
		 * - L'utilisateur appuye sur le niveau 3
		 */
		
		
		
		ISysteme_de_Controle sdc = Factory_Systeme_de_Controle.CreerSysteme_de_Controle();
		IIHM_Simule ihm = Factory_IHM_Simule.CreerIhm_Simule(5, sdc);
		IAscenseur ascenseur = Factory_Ascenseur.CreerAscenseur(4, 10, sdc);
		System.out.println(ihm.AffichageEtage());
		
		//.ihmOutdoor[0].Monter();
		
		//ihm.ihmIndoor.ChoixNiveau(3);
		
	}
}
