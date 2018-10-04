package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICapteur;

public class Capteur implements ICapteur {
	
	public Capteur()
	{
		
	}
	
	@Override
	public boolean get_detection() {
		return false;
	}

}
