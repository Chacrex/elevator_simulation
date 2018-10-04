package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Implementation;


import java.util.ArrayList;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur.Sens;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Factory.Factory_IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Factory.Factory_Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Systeme_de_Controle implements ISysteme_de_Controle {
	public class Deplacement 
	{
		private int arriver;
		private Sens sens;
		public Deplacement(int etage_arriver, Sens sensDeplacement)
		{
			arriver = etage_arriver;
			sens = sensDeplacement;
		}
		
		public int getEtage()
		{
			return arriver;
		}
		
		public Sens getSens()
		{
			return sens;
		}
	}
	
	private ArrayList<Deplacement> listeDeplacements;
	private IAscenseur ascenseur;
	private IIHM_Simule ihm;

	public Systeme_de_Controle() {
		
	}
	
	@Override
	public int AffichagePosition() {
		return ascenseur.get_position();
	}
	
	@Override
	public void AssignerAscenseur(IAscenseur ascenseurassigner)
	{
		ascenseur = ascenseurassigner;
	}

	@Override
	public void AppelAscenseur(int niveauAppel, ISysteme_de_Controle.SensAppel sens) {
		/* Optimisation : */
		if(listeDeplacements.get(listeDeplacements.size()-1).getEtage() > niveauAppel)
			listeDeplacements.add(new Deplacement(niveauAppel, Sens.Montee));
		else
			listeDeplacements.add(new Deplacement(niveauAppel, Sens.Descente));
	}

	@Override
	public void ChoixNiveau(int niveau) {
		if(listeDeplacements.get(listeDeplacements.size()-1).getEtage() > niveau)
			listeDeplacements.add(new Deplacement(niveau, Sens.Montee));
		else
			listeDeplacements.add(new Deplacement(niveau, Sens.Descente));
	}
	
	// Il faut enlever le bool inutile, et puis merde j'aime pas les boules, j'suis pô pd
	@Override
	public void Set_OuverturePorte()
	{
		ihm.GererPortes(ascenseur.get_position(), true);
		listeDeplacements.remove(0);
		ihm.GererPortes(ascenseur.get_position(), false);
		while(true)
		{
			ascenseur.Marche(listeDeplacements.get(0).getSens());
			if(ascenseur.get_position() == listeDeplacements.get(0).getEtage())
			{
				ascenseur.Arret_Niveau();
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		/*
		 * Scénario :
		 * - L'ascenseur se trouve au niveau 5
		 * - Le SdC reçoit une demande pour monter provenant du niveau 2
		 * - Le SdC envoie une commande de descente à l'ascenseur
		 * - Le SdC reçoit une commande pour aller au niveau 4
		 * - Le SdC envoie la commande à l'ascenseur pour monter au niveau 4
		 * - Le SdC commande l'ouverture des portes
		 */
		
		Systeme_de_Controle Sdc = new Systeme_de_Controle();
		
		IAscenseur asc = Factory_Ascenseur.CreerAscenseur(10, 10, Sdc);
		IIHM_Simule ihm = Factory_IHM_Simule.CreerIhm_Simule(10, Sdc);
		Sdc.AssignerAscenseur(asc);
		
		Sdc.ihm = ihm;
		Sdc.ascenseur = asc;
		Sdc.listeDeplacements = new ArrayList<Deplacement>();
		
		IOutdoor outdoor = Factory_IHM_Simule.CreerOutdoor(2);
		
		outdoor.Monter();
		
		
	}
	
}
