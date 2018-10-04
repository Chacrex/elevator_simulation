package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur.Sens;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IMoteur;

public class Moteur implements IMoteur {

	private int vitesse;
	
	@Override
	public void Marche(Sens sens) {
		// TODO Auto-generated method stub
		System.out.println("Le moteur fonctionne");
	}

	@Override
	public int get_vitesse() {
		return vitesse;
	}

	@Override
	public void Arret() {
		System.out.println("Le moteur s'arrete");

	}

}
