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
	
	public static IIndoor CreerIndoor(ISysteme_de_Controle sdc) {
		return new Indoor(sdc);
	}
	
	public static IOutdoor CreerOutdoor(int niveauOutdoor, ISysteme_de_Controle sdc) {
		Outdoor current = new Outdoor(niveauOutdoor, sdc);
		return current;
	}
}
