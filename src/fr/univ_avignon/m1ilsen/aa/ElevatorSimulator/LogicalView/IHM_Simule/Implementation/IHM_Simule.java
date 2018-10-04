package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIndoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

import java.util.List;

public class IHM_Simule implements IIHM_Simule {
	
	private IIndoor ihmIndoor;
	private List<IOutdoor> ihmOutdoor;
	private ISysteme_de_Controle SdC;
	private IAscenseur Asc;
	
	private class IHM_Outdoor implements IOutdoor{
		
		int niveau;
		
		public void Descendre() {
			SdC.AppelAscenseur(niveau, ISysteme_de_Controle.SensAppel.Bas);
		}
		
		public void Monter() {
			SdC.AppelAscenseur(niveau, ISysteme_de_Controle.SensAppel.Haut);
		}
		
		public void GetEtatPortes() {
			
		}
		
		public void SetEtatPortes() {
			
		}
	}
	
	private class IHM_Indoor implements IIndoor{
		
		public void ChoixNiveau(int niveau) {
			SdC.ChoixNiveau(niveau);
		}
	}

	public int AffichageEtage() {
		return SdC.AffichagePosition();
	}
	
	public IIndoor getIndoor() {
		return ihmIndoor;
	}
	
	public List<IOutdoor> getOutdoor(){
		return ihmOutdoor;
	}
}
