package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface;


public interface IMoteur {
	void Marche(IAscenseur.Sens sens);
	int get_vitesse();
	void Arret();
}
