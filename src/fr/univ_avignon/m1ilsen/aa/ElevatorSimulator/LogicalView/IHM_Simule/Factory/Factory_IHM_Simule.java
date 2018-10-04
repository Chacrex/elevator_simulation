package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Factory;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation.IHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation.Indoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Implementation.Outdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIndoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IOutdoor;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Factory_IHM_Simule {

	public static IIHM_Simule CreerIhm_Simule(int nbNiveau, ISysteme_de_Controle sdc) {
		return new IHM_Simule(nbNiveau, sdc);
	}
	
	public static IIndoor CreerIndoor() {
		return new Indoor();
	}
	
	public static IOutdoor CreerOutdoor(int niveauOutdoor) {
		Outdoor current = new Outdoor(niveauOutdoor);
		return current;
	}
}
