package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Implementation;


import java.util.ArrayList;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur.Sens;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Systeme_de_controle implements ISysteme_de_Controle {
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
	private IOutdoor outdoor;
	private IAscenseur ascenseur;
	
	@Override
	public int AffichagePosition() {
		return ascenseur.get_position();
	}

	@Override
	public void AppelAscenseur(int niveauAppel, ISysteme_de_Controle.SensAppel sens) {
		/*Optimisation : */
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
	
	// Il faut enlever le bool inutile, et puis merde j'aime pas les boules, j'suis p� pd
	@Override
	public void Set_OuverturePorte(boolean ouverturePorte)
	{
		//outdoor.Set_OuverturePorte(true);
		listeDeplacements.remove(0);
		//outdoor.Set_OuverturePorte(false);
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
	
	
	
}
