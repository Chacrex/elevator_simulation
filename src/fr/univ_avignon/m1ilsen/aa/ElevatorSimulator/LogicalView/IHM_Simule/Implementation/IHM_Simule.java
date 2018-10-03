package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIndoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;

import java.util.List;

public class IHM_Simule implements IIHM_Simule {
	
	private IIndoor ihmIndoor;
	private List<IOutdoor> ihmOutdoor;
	
	private class IHM_Outdoor {
		
		public void Descendre() {
			
		}
		
		public void Monter() {
			
		}
		
		public void GetEtatPortes() {
			
		}
	}
	
	private class IHM_Indoor {
		
		public void ChoixNiveau() {
			
		}
	}

	public int AffichageEtage() {
		return 0;
	}
}
