package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIndoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Indoor implements IIndoor{
	
	private ISysteme_de_Controle SdC;
	
	public Indoor(ISysteme_de_Controle sdc) {
		this.SdC = sdc;
	}
	
	public void ChoixNiveau(int niveau) {
		SdC.ChoixNiveau(niveau);
	}
}
