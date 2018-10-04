package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation;
import java.util.ArrayList;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICabine;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICapteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Ascenseur implements IAscenseur {
	
	
	private Etat_Ascenseur etat;
	private ArrayList<ICapteur> capteurs;
	private int position;
	private Sens sens;
	private ICabine cabine;

	public Ascenseur(int nombreEtage, int vitesseMoteur, ISysteme_de_Controle controlSystem)
	{
		etat = Etat_Ascenseur.Repos;
		for(int i=0; i<nombreEtage;i++)
			Factory_Ascenseur.CreerCapteur();
		Factory_Ascenseur.CreeCabine(controlSystem, vitesseMoteur);
	}
	
	@Override
	public void Marche(Sens sens) {
		cabine.mise_en_mvt(sens);
	}

	@Override
	public void Arret_Niveau() {
		
		while(true)
		{
			if(capteurs.get(position*2).get_detection() && capteurs.get(position*2+1).get_detection())
			{
				cabine.fin_mvt();
				break;
			}
		}
	}

	@Override
	public Etat_Ascenseur get_etat() {
		return etat;
	}

	@Override
	public int get_position() {
		return position;
	}

	@Override
	public Sens get_sens() {
		return sens;
	}

}
