package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory.Factory_Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICabine;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IMoteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Cabine implements ICabine {
	private Etat_cabine etat_cabine;
	private int position;
	private ISysteme_de_Controle SdC;
	private IMoteur moteur;
	
	public Cabine(ISysteme_de_Controle controlSystem, int vitesseMoteur)
	{
		etat_cabine = Etat_cabine.ouverte;
		SdC = controlSystem;
		position = 0;
		moteur = Factory_Ascenseur.CreeMoteur(vitesseMoteur);
	}
	
	@Override
	public int get_position() {
		return position;
	}

	@Override
	public void ouverture() {
		SdC.Set_OuverturePorte();
	}

	@Override
	public Etat_cabine get_etat_cabine() {
		return etat_cabine;
	}

	@Override
	public void mise_en_mvt(IAscenseur.Sens sens) {
		moteur.Marche(sens);
	}

	@Override
	public void fin_mvt() {
		// TODO Auto-generated method stub
		moteur.Arret();
	}

}
