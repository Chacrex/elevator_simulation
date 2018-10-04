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
		this.SdC = sdcontrole;
		this.ihmIndoor = Factory_IHM_Simule.CreerIndoor(SdC);
		this.ihmOutdoor = new Outdoor[nbNiveau];
		for(int i = 0; i < nbNiveau; i++) {
			ihmOutdoor[i] = Factory_IHM_Simule.CreerOutdoor(i, SdC);
		}
	}
	
	public void GererPortes(int niveau, boolean b) {
		ihmOutdoor[niveau].SetEtatPortes(b);
	}
	
	public int AffichageEtage() {
		return SdC.AffichagePosition();
	}
	

	@Override		
	public void Descendre(int etage)
	{
		ihmOutdoor[etage].Descendre();
	}
	
	@Override
	public void Monter(int etage)
	{
		ihmOutdoor[etage].Monter();
	}
	
	@Override
	public boolean GetEtatPorte(int etage)
	{
		return ihmOutdoor[etage].GetEtatPortes();
	}
	
	public void ChoixNiveau(int etageVoulu)
	{
		ihmIndoor.ChoixNiveau(etageVoulu);
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
		IIHM_Simule ihm = new IHM_Simule(5, sdc);
		IAscenseur ascenseur = Factory_Ascenseur.CreerAscenseur(5, 10, sdc);
		
		sdc.AssignerAscenseur(ascenseur);
		sdc.AssignerIHM(ihm);
		
		System.out.println("Position de l'ascenseur : " + ihm.AffichageEtage());
		
		System.out.println("L'utilisateur appuye sur le bouton pour monter");
		ihm.Monter(0);
		
		System.out.println("L'utilisateur choisit le niveau 3");
		ihm.ChoixNiveau(3);
		
	}
}
