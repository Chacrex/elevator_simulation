package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Factory.Factory_Systeme_de_Controle;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Outdoor implements IOutdoor{
	
	private int niveauOutdoor;
	private ISysteme_de_Controle SdC;
	private boolean etatPorte;
	
	public Outdoor(int niveauOutdoor, ISysteme_de_Controle sdc) {
		this.niveauOutdoor = niveauOutdoor;
		this.SdC = sdc;
	}
	
	public void Descendre() {
		SdC.AppelAscenseur(niveauOutdoor, ISysteme_de_Controle.SensAppel.Bas);
	}
	
	public void Monter() {
		SdC.AppelAscenseur(niveauOutdoor, ISysteme_de_Controle.SensAppel.Haut);
	}
	
	public boolean GetEtatPortes() {
		return etatPorte;
	}

	
	public int GetniveauOutdoor() {
		return niveauOutdoor;
	}

	@Override
	public void SetEtatPortes(boolean b) {
		etatPorte = b;
	}
}
